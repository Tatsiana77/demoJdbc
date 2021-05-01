package com.tatchik.demojdbc.dao;


import com.tatchik.demojdbc.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Author> getAllAuthor() {
        String SQL = "SELECT*FROM Author";
        List<Author> authors = jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(Author.class));
        return authors;
    }

    @Override
    public List<Author> getAllAuthorWithBooks() {
        return null;
    }



    @Override
    public void saveEntity(Author author) {
        String SQL = "INSERT INTO Author VALUES (6, ?,?)";
        jdbcTemplate.update( SQL, author.getName(), author.getSurname());
        System.out.println("Author successfully save.");
    }

    @Override
    public Author getAuthorById(Integer id) {
        String SQL = "SELECT * FROM Author WHERE  id =?";
       return  jdbcTemplate.query(SQL, new Object[]{id}, new BeanPropertyRowMapper<>(Author.class)).stream().findAny().orElse(null);

    }

    @Override
    public Author getAuthorByName( String name) {
        String SQL = "SELECT*FROM Author WHERE  name=?";
        Author author = jdbcTemplate.query(SQL, new  Object[]{name}, new BeanPropertyRowMapper<>(Author.class)).stream().findAny().orElse(null);
       return  author;

    }

    @Override
    public Author getAuthorWithBookById(Integer idAuthor) {
        return null;
    }

    @Override
    public void updateAuthor(Integer id, Author author) {
        String SQL = "UPDATE  Author SET name =?, surname =? WHERE id =?";
        jdbcTemplate.update(SQL, author.getName(), author.getSurname(), id);
        System.out.println("Author with id updated");

    }

    @Override
    public void deleteById(Integer id) {
        String SQL = "DELETE  FROM Author  WHERE id =?";
        jdbcTemplate.update(SQL, id);
        System.out.println("Author with id delete ");
    }
}
