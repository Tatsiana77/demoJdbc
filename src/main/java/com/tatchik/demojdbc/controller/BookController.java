package com.tatchik.demojdbc.controller;

import com.tatchik.demojdbc.dao.BookDao;
import com.tatchik.demojdbc.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    private BookDao bookDao;

    @Autowired
    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @RequestMapping(value = "/books")
    public String getAllBook(ModelMap modelMap) {
        List<Book> books = bookDao.getAllBook();
        modelMap.addAttribute("books", books);
        return "book";
    }

}
