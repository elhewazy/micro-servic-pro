//package com.genspark.catalog_service.services;
//
//import com.genspark.catalog_service.model.Book;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.List;
//
//@FeignClient(name = "book-service")
//public interface BookClient {
//
//    @GetMapping("/books/catalogs/{catalogId}")
//    List<Book> getBookOfCatalog(@PathVariable Long catalogId);
//}
