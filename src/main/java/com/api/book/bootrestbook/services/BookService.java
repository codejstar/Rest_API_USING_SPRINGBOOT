package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entitiesModel.Book;

@Component
public class BookService {

    private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(1, "Java Complete Guid", "xyz"));
        list.add(new Book(2, "JavaScript Complete Guid", "123"));
        list.add(new Book(3, "Python Complete Guid", "IIII"));
    }

    // Get all books
    public List<Book> getBooks() {
        return list;
    }

    // get single book by id
    public Book getBookById(int id) {
        Book book = null;
        book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        return book;
    }

    public void addBook(Book b) {
        list.add(b);
    }

}
