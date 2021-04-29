package com.tatchik.demojdbc.RestController;

import com.tatchik.demojdbc.dao.AuthorDao;
import com.tatchik.demojdbc.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorRestController {

    private AuthorDao authorDao;

    @Autowired
    public AuthorRestController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/api/author")
    public List<Author> getAllAuthor() {
        return authorDao.getAllAuthor();
    }

    @GetMapping("/api/authorWithBooks")
    public List<Author> getAllAuthorWithBook() {
        return authorDao.getAllAuthorWithBooks();
    }


    @PostMapping("/api/author")
    public void saveAuthor(@RequestBody  Author author) {
        authorDao.saveEntity(author);
    }

    @DeleteMapping("/api/author")
    public void deleteAuthorById(@PathVariable("id") Integer id) {
        authorDao.deleteById(id);
    }

        @GetMapping("/api/author/{idAuthor}")
    public Author getAuthorById(@PathVariable("idAuthor") Integer id) {
        return authorDao.getAuthorById(id);
    }

    @GetMapping("/api/author/name")
    public Author getAuthorByName(@RequestParam String name) {
        return authorDao.getAuthorByName(name);
    }


}
