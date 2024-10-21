package com.api.book.bootrestbook.controllers;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entitiesModel.Book;

// @Controller
@RestController
public class BookController {

    // @RequestMapping(value = "/books", method = RequestMethod.GET)
    // @ResponseBody
    @GetMapping("/books")
    public Book getBook() {
        Book book = new Book();
        book.setId(0);
        book.setAuthor("Jagdeep Jakhu");
        book.setTitle("Java Complete Guid");
        return book;
    }
}
