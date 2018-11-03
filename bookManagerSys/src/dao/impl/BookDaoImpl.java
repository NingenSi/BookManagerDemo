package dao.impl;

import dao.BaseDAO;
import entiy.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl extends BaseDAO implements dao.BookDao {

    /**
     * 查询所有书
     * @return
     */
    @Override
    public List<Book> queryAllBook(int page, int pageSize){
        ArrayList<Book> booksList = new ArrayList<>();
        Connection conn = getConnection();
        ResultSet rs =null;
        PreparedStatement preStat = null;
        String sql = "select * from(select rownum as r,bookname,author,publish,price,description_ from t_book where rownum <= ?)t where t.r > ?";
        try {
            preStat = conn.prepareStatement(sql);
            preStat.setInt(1,page*pageSize);
            preStat.setInt(2,(page-1)*pageSize);
            rs = preStat.executeQuery();
            getAllData(booksList, rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return booksList;
    }

    /***
     * 书名模糊查询
     * @param bookName
     * @return
     */
    @Override
    public List<Book> queryBookLikeName(String bookName){
        ArrayList<Book> booksList = new ArrayList<>();
        String sql = "select bookname,author,publish,price,description_ from t_book where bookname like ?";
        Connection conn = getConnection();
        PreparedStatement preStat = null;
        ResultSet rs = null;
        try {
            preStat = conn.prepareStatement(sql);
            preStat.setString(1,"%"+bookName+"%");
            rs = preStat.executeQuery();
            getAllData(booksList, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,preStat,rs);
        }
        return booksList;
    }

    /**
     * 书名查找书
     * @param bookName
     * @return
     */
    @Override
    public boolean queryBookByName(String bookName){
        ArrayList<Book> booksList = new ArrayList<>();
        String sql = "select bookname,author,publish,price,description_ from t_book where bookname = ?";
        Connection conn = getConnection();
        PreparedStatement preStat = null;
        ResultSet rs = null;
        try {
            preStat = conn.prepareStatement(sql);
            preStat.setString(1,bookName);
            rs = preStat.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,preStat,rs);
        }
        return false;
    }
    /**
     * 删除图书
     * @param bookName
     * @return
     */
    @Override
    public boolean deleteBookByBookName(String bookName){
        String sql = "delete from t_book where bookname = ?";
        if (queryBookByName(bookName)){
            if (operateDML(sql,new Object[]{bookName})){
                return true;
            }
        }
        return false;
    }

    /**
     * 修改价格
     * @param bookName
     * @return
     */
    @Override
    public boolean modifyPriceByBookName(String bookName, double price){
        String sql = "update t_book set price = ? where bookname = ?";
        if (queryBookByName(bookName)){
            if (operateDML(sql,new Object[]{price,bookName})){
                return true;
            }
        }
        return false;
    }

    /**
     * 添加图书
     * @param book
     * @return
     */
    @Override
    public boolean addBook(Book book){
        String sql = "insert into t_book values (t_bookid_sq.nextval,?,?,?,?,?)";
        if (!queryBookByName(book.getBookname())){
            if (operateDML(sql,new Object[]{book.getBookname(),book.getAuthor(),book.getPublish(),book.getPrice(),book.getDescription_()})){
                return true;
            }
        }
        return false;
    }
    /**
     * 查询所有数据获取
     * @param booksList
     * @param rs
     * @throws SQLException
     */
    private void getAllData(ArrayList<Book> booksList, ResultSet rs) throws SQLException {
        while (rs.next()){
            Book book = new Book();
            book.setBookname(rs.getString("bookname"));
            book.setAuthor(rs.getString("author"));
            book.setPublish(rs.getString("publish"));
            book.setPrice(rs.getDouble("price"));
            book.setDescription_(rs.getString("description_"));
            booksList.add(book);
        }
    }

    /**
     * 获取书的数量
     * @return
     */
    @Override
    public int getMaxPage() {
        Connection conn = getConnection();
        ResultSet rs =null;
        PreparedStatement preStat = null;
        String sql = "select count(1) from t_book";
        try {
            preStat = conn.prepareStatement(sql);
            rs = preStat.executeQuery();
            while (rs.next()){
               return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
