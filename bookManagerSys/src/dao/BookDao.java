package dao;

import entiy.Book;

import java.util.List;

public interface BookDao {
    List<Book> queryAllBook(int page, int pageSize);

    List<Book> queryBookLikeName(String bookName);

    boolean queryBookByName(String bookName);

    boolean deleteBookByBookName(String bookName);

    boolean modifyPriceByBookName(String bookName, double price);

    boolean addBook(Book book);

    int getMaxPage();
}
