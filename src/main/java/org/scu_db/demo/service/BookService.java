package org.scu_db.demo.service;

import org.scu_db.demo.model.Book;
import org.scu_db.demo.model.Title;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();
    Book findBookById(Integer Id);
    List<Book> findBookByIdUseSql(Integer Id);
    Integer deleteBookById(Integer id);
    Integer updateBook(Book book, Integer method);
    List<Integer> findbookidwhichnotborrowed();

    Integer numofbookcall123();
    List<String> findcallnum();
}
