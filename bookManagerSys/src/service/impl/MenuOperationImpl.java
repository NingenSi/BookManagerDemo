package service.impl;

import dao.BookDao;
import dao.UserDao;
import dao.impl.BookDaoImpl;
import dao.impl.UserDaoImpl;
import entiy.Book;
import entiy.User;

import java.util.List;
import java.util.Scanner;

public class MenuOperationImpl implements service.MenuOperation, service.MenuOperation {
    private Scanner input = new Scanner(System.in);
    private User user = null;
    private BookDao bookDao = new BookDaoImpl();
    private UserDao userDao = new UserDaoImpl();
    private int page = 1; //页数
    private int pageSize = 5; //每页显示数
    private int maxPage = (bookDao.getMaxPage()%pageSize ==0)?bookDao.getMaxPage()/pageSize:bookDao.getMaxPage()/pageSize+1; //最大页数

    public MenuOperationImpl() {
    }

    public MenuOperationImpl(User user) {
        this.user = user;
    }

    /**
     * 修改图书价格
     */
    @Override
    public void modifyBook(){
        System.out.println("请输入需要修改价格的书名!");
        String modifBookName = input.next();
        System.out.println("请输入新价格!");
        double price = input.nextDouble();
        if (bookDao.modifyPriceByBookName(modifBookName, price))
            System.out.println("修改" + modifBookName + "价格为" + price + "成功!");
        else System.out.println("修改" + modifBookName + "价格失败");
    }

    /**
     * 添加图书
     */
    @Override
    public void addBook(){
        Book newBook = new Book();
        System.out.println("请输入书名;");
        newBook.setBookname(input.next());
        System.out.println("请输入作者;");
        newBook.setAuthor(input.next());
        System.out.println("请输入出版社;");
        newBook.setPublish(input.next());
        System.out.println("请输入价格;");
        newBook.setPrice(input.nextDouble());
        System.out.println("请输入描述;");
        newBook.setDescription_(input.next());
        if(bookDao.addBook(newBook)){
            System.out.println("添加 "+newBook.getBookname()+" 成功！");
        }else System.out.println("添加 "+newBook.getBookname()+" 失败！");
    }

    /**
     * 删除图书
     */
    @Override
    public void deleteBook(){
        System.out.println("请输入要删除的书名:");
        String delBookName = input.next();
        if (bookDao.deleteBookByBookName(delBookName)) {
            System.out.println("删除" + delBookName + "成功!");
        } else System.out.println("删除" + delBookName + "失败!");
    }

    /**
     * 修改密码
     */
    @Override
    public void modifyPwd() {
        User modifyUser = new User();
        String modifyUserName;
        if (user.getType_() == 1) {
            System.out.println("请输入用户名:");
            modifyUserName = input.next();
        }
        else modifyUserName = user.getUsername();
        System.out.println("请输入原密码:");
        String oldPwd = input.next();
        System.out.println("请输入新密码:");
        String newFirstPwd = input.next();
        System.out.println("请再次输入新密码:");
        String newSecondPwd = input.next();
        if (newFirstPwd.equals(newSecondPwd)) {//判断两次新密码是否相等
            modifyUser.setUsername(modifyUserName);
            modifyUser.setPwd(oldPwd);
            if(userDao.modifyPwd(modifyUser,newFirstPwd)){
                System.out.println("修改密码成功!");
            }else System.out.println("修改失败!");
        } else System.out.println("两次新密码不一致!退出修改!");

    }

    /**
     * // 注册新用户
     */
    @Override
    public void registerNewUser(){

        User user = new User();
        System.out.println("请输入用户名:");
        String newUserName = input.next();
        System.out.println("请输入密码:");
        String firstPwd = input.next();
        System.out.println("请再次输入密码:");
        String secondPwd = input.next();
        if (firstPwd.equals(secondPwd)) {
            user.setUsername(newUserName);
            user.setPwd(firstPwd);
            if (userDao.register(user))
                System.out.println("注册成功!");
            else System.out.println("注册失败!");
        } else {
            System.out.println("两次密码不一致，退出注册系统!");
        }
    }

    /**
     * 按书名模糊查询图书
     * @param bookList
     */
    @Override
    public void queryByLikeBookName(List<Book> bookList){

        bookList.clear();
        System.out.println("请输入关键字!");
        String bookName = input.next();
        bookList.clear();
        bookList = bookDao.queryBookLikeName(bookName);
        if (bookList.size() == 0)
            System.out.println("没有搜索结果！");
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    /**
     * 分页
     * @param bookList
     */
    @Override
    public void queryPage(List<Book> bookList){
        int pageMark;
        page = 1;
        getBookInfo(bookList);
        while (true) {
            pageMark = input.nextInt();
            if (pageMark == 0)
                break;
            switch (pageMark) {
                case 1://首页
                    if (page > 1) {
                        page = 1;
                        getBookInfo(bookList);
                    } else System.out.println("已经是首页啦!");
                    break;
                case 2://上一页
                    if (page > 1) {
                        page--;
                        getBookInfo(bookList);
                    } else System.out.println("已经是首页啦!");
                    break;
                case 3://下一页
                    if (page < maxPage) {
                        page++;
                        getBookInfo(bookList);
                    } else System.out.println("已经是尾页啦!");
                    break;
                case 4:
                    if (page < maxPage) {
                        page = maxPage;
                        getBookInfo(bookList);
                    } else System.out.println("已经是尾页啦!");
                    break;
            }
        }
    }

    /**
     * 获取书的信息
     *
     * @param bookList
     */
    private void getBookInfo(List<Book> bookList) {
        bookList.clear();
        bookList = bookDao.queryAllBook(page, pageSize);
        for (Book book : bookList) {
            System.out.println(book);
        }
        System.out.println("1.首页  2.上一页  当前页" + page + "  3.下一页  4.尾页  0.返回菜单");
    }
}
