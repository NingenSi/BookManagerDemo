package service;

import entiy.Book;

import java.util.List;

public interface MenuOperation {
    void modifyBook();

    void addBook();

    void deleteBook();

    void modifyPwd();

    void registerNewUser();

    void queryByLikeBookName(List<Book> bookList);

    void queryPage(List<Book> bookList);
}
