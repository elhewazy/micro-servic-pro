package com.genspark.book_service.services;

import com.genspark.book_service.entities.Book;

import javax.xml.catalog.Catalog;
import java.util.List;
import java.util.Optional;


public interface BookService {
    List<Book> getAllBooks();
    Optional<Book> getbyId(Long id);
    Book addBook(Book book);
    String deleteBook(Long id);
    Book updateBook(Book book);
}
