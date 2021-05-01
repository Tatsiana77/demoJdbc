package com.tatchik.demojdbc.dao;

import com.tatchik.demojdbc.model.Author;

import javax.sql.DataSource;
import java.util.List;

public interface AuthorDao {

    public List<Author> getAllAuthor();

    public List<Author> getAllAuthorWithBooks();



    public void updateAuthor(Integer id, Author author);

    public void saveEntity(Author author);

    public Author getAuthorById(Integer id);

    public Author getAuthorByName(String name);

    public Author getAuthorWithBookById(Integer idAuthor);

    public void deleteById(Integer id);
}
