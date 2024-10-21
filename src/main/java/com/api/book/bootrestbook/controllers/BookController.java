package com.api.book.bootrestbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.api.book.bootrestbook.entitiesModel.Book;
import com.api.book.bootrestbook.services.BookService;

// @Controller
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // @RequestMapping(value = "/books", method = RequestMethod.GET)
    // @ResponseBody
    @GetMapping("/books")
    public List<Book> getBook() {

        // Book book = new Book();
        // book.setId(0);
        // book.setAuthor("Jagdeep Jakhu");
        // book.setTitle("Java Complete Guid");
        // return book;

        return this.bookService.getBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") int id) {
        return this.bookService.getBookById(id);
    }
}
