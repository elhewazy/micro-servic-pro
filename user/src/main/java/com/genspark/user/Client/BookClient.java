package com.genspark.user.Client;

import com.genspark.user.Entity.Book;
import com.genspark.user.Entity.Catalog;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.*;

import java.util.List;

@HttpExchange
public interface BookClient {

    @GetExchange("/book/all")
    List<Book> findAllBooks();

    @PostExchange("/book/add")
    Book addNewBook(@RequestBody Book book);

    @PutExchange("/book")
    Book updateBook(@RequestBody Book book);

    @DeleteExchange("/book/{id}")
    String deleteBook(@PathVariable long id);

}
