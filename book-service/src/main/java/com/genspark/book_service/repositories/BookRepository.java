package com.genspark.book_service.repositories;

import com.genspark.book_service.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT book FROM Book book JOIN b.catalogIds c WHERE c = :catalogId")
    List<Book> findAllByCatalogId(@Param("catalogId") Long catalogId);
}
