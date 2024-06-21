package com.genspark.book_service.controllers;

import com.genspark.book_service.entities.Book;
import com.genspark.book_service.repositories.BookRepository;
import com.genspark.book_service.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookServ;

    @PostMapping("/add")
    public Book add(@RequestBody Book book) {
        return bookServ.addBook(book);
    }

    @GetMapping("/all")
    public List<Book> findAll() {
        return bookServ.getAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<Book> findById(@PathVariable Long id) {
        return bookServ.getbyId(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        bookServ.deleteBook(id);
        return "Deleted Book.";
    }

    @PutMapping
    public Book update(@RequestBody Book book){
        return bookServ.updateBook(book);
    }

    @GetMapping("/catalog/{catalogId}")
    public List<Book> getBooksByCatalogId(@PathVariable Long catalogId) {
        return bookServ.getBookOfCatalog(catalogId);
    }

}
