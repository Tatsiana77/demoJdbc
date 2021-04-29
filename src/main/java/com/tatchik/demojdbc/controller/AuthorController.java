package com.tatchik.demojdbc.controller;

import com.tatchik.demojdbc.dao.AuthorDao;
import com.tatchik.demojdbc.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AuthorController {
    private AuthorDao authorDao;

    @Autowired
    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }


    @RequestMapping(value="/authors", method = RequestMethod.GET)
    public String getAllAuthor(ModelMap modelMap) {
        List<Author> author = authorDao.getAllAuthor();
        modelMap.addAttribute("author", author);
        return "author";
    }


    @RequestMapping("/author/edit")
    public String editAuthor(ModelMap modelMap, @RequestParam Integer id) {
        Author author = authorDao.getAuthorById(id);
        modelMap.addAttribute("author", author);
        return "editAuthor";
    }

    @RequestMapping(value="/edit-author", method =RequestMethod.POST)
    public String saveAuthor(@ModelAttribute("author") Author author) {
        authorDao.saveEntity(author);
        return "redirect:/author";
    }
    @RequestMapping("/author/{id}")
    public String deleteAuthor(ModelMap modelMap, @RequestParam Integer id){
       authorDao.deleteById(id);
        return  "deleteAuthor";
    }

}
