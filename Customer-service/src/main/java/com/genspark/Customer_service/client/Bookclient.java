package com.genspark.Customer_service.client;

import com.genspark.Customer_service.model.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface Bookclient {
    @GetExchange("/book/all")
    public List<Book> getBooks();
}
