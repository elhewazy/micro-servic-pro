package com.genspark.book_service.services;

import com.genspark.book_service.entities.Book;
import com.genspark.book_service.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.catalog.Catalog;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    BookRepository bookRepo;

    @Override
    public List<Book> getAllBooks() {
        return this.bookRepo.findAll();
    }

    @Override
    public Optional<Book> getbyId(Long id) {
        return this.bookRepo.findById(id);
    }

    @Override
    public Book addBook(Book book) {
        return this.bookRepo.save(book);
    }

    @Override
    public String deleteBook(Long id) {
        return "Book deleted";
    }

    @Override
    public Book updateBook(Book book) {
        return this.bookRepo.save(book);
    }
}
