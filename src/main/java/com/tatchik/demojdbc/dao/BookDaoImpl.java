package com.tatchik.demojdbc.dao;


import com.tatchik.demojdbc.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> getAllBook() {
        String SQL = "SELECT*FROM Book";
        List<Book> books = jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(Book.class));
        return books;
    }

    @Override
    public List<Book> getAllBookWithJoin() {
        String sql = "SELECT  * FROM Book FULL  OUTER JOIN Author ON Book.Author_id = Author.id";
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
        return books;

    }

    @Override
    public void saveBook(Book book) {
        String SQL = "INSERT INTO Book (title)  VALUES ( 11, ?, ?)";
        jdbcTemplate.update(SQL, book.getTitle());

    }

    @Override
    public void deleteBookById(Integer idBook) {
        String SQL = "DELETE  FROM Book  WHERE id =?";
        jdbcTemplate.update(SQL, idBook);
    }

    @Override
    public void updateBook(Integer idBook, Book book) {
        String SQL = "UPDATE  Book  SET  title =? WHERE id=?";
        jdbcTemplate.update(SQL, book.getTitle(), idBook);
        System.out.println("Book successfully saved");
    }

    @Override
    public Book getBookById(Integer idBook) {
        String SQL = "SELECT*FROM Book  WHERE id =?";
        Book book =  jdbcTemplate.query(SQL, new Object[]{idBook}, new  BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
        return book;
    }

    @Override
    public Book getBookByTitle(String title) {
        String SQL = "SELECT*FROM Book WHERE  title =?";
        Book book =  jdbcTemplate.query(SQL, new Object[]{title}, new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
        return book;
    }
}
