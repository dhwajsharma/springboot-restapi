package com.api.book.bootrestbook.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

    private BookRepository bookRepository;

    // private static List<Book> list = new ArrayList<>();

    // static {
    // list.add(new Book(1, "Java", "James Gosling"));
    // list.add(new Book(2, "JS", "Brendan Eich"));
    // list.add(new Book(3, "python", "Guido van Rossum"));
    // }

    // get all books
    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    // get single book by id
    public Book getBookById(int id) {
        Book book = null;
        try {
            // book = list.stream().filter(item -> item.getId() == id).findFirst().get();
            book = this.bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // add book
    public Book addBook(Book book) {
        Book result = bookRepository.save(book);
        return result;
    }

    // delete book
    public void deleteBook(int id) {
        // list = list.stream().filter(book -> book.getId() !=
        // id).collect(Collectors.toList());
        bookRepository.deleteById(id);
    }

    // update book
    public void updateBook(Book book, int id) {
        // list.stream().map(b -> {
        // if (b.getId() == id) {
        // b.setTitle(book.getTitle());
        // b.setAuthor(book.getAuthor());
        // }
        // return b;
        // }).collect(Collectors.toList());

        book.setId(id);
        bookRepository.save(book);
    }

}
