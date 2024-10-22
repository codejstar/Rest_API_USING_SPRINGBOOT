package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entitiesModel.Book;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // private static List<Book> list = new ArrayList<>();

    // static {
    // list.add(new Book(1, "Java Complete Guid", "xyz"));
    // list.add(new Book(2, "JavaScript Complete Guid", "123"));
    // list.add(new Book(3, "Python Complete Guid", "IIII"));
    // }

    // Get all books
    public List<Book> getBooks() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    // get single book by id
    public Book getBookById(int id) {
        Book book = null;
        try {
            // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
            book = this.bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public Book addBook(Book b) {
        // list.add(b);
        Book result = bookRepository.save(b);
        return result;
    }

    // delete book
    public void removeBook(int bookId) {
        // list = list.stream().filter(book -> book.getId() !=
        // bookId).collect(Collectors.toList());
        bookRepository.deleteById(bookId);
    }

    // update book
    public void updateBook(Book book, int bookId) {
        // list = list.stream().map(b -> {
        // if (b.getId() == bookId) {
        // b.setTitle(book.getTitle());
        // b.setAuthor(book.getAuthor());
        // }
        // return b;
        // }).collect(Collectors.toList());
        book.setId(bookId);
        bookRepository.save(book);
    }

}
