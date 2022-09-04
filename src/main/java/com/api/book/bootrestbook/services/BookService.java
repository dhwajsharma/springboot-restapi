package com.api.book.bootrestbook.services;

import java.util.*;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

    private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(1, "Java", "James Gosling"));
        list.add(new Book(2, "JS", "Brendan Eich"));
        list.add(new Book(3, "python", "Guido van Rossum"));
    }

    // get all books
    public List<Book> getAllBooks() {
        return list;
    }

    // get single book by id
    public Book getBookById(int id) {
        Book book = null;
        book = list.stream().filter(item -> item.getId() == id).findFirst().get();
        return book;
    }

    // add book
    public Book addBook(Book book) {
        list.add(book);
        return book;
    }

}
