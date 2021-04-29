package com.tatchik.demojdbc.RestController;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import com.tatchik.demojdbc.dao.BookDao;
import com.tatchik.demojdbc.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookRestController {

    private BookDao bookDao;

    @Autowired
    public BookRestController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/api/book")
    public List<Book> getAllBook() {
        return bookDao.getAllBook();
    }

    @GetMapping("/api/bookWithAuthor")
    public List<Book> getAllBookWithJoin() {
        return bookDao.getAllBookWithJoin();
    }


}
