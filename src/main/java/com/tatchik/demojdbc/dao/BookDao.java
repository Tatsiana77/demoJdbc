package com.tatchik.demojdbc.dao;

import com.tatchik.demojdbc.model.Book;

import javax.sql.DataSource;
import java.util.List;

public interface BookDao {


    public List<Book> getAllBook();

    public List<Book> getAllBookWithJoin();

    void saveBook(Book book);

    public void deleteBookById(Integer idBook);

    void updateBook(Integer idBook, Book book);

    public  Book getBookById(Integer idBook);

   public  Book getBookByTitle(String title);


}
