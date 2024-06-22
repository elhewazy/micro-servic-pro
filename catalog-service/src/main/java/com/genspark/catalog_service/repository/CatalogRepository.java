package com.genspark.catalog_service.repository;

import com.genspark.catalog_service.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {

    @Query("SELECT c from Catalog c WHERE LOWER(c.category) LIKE LOWER(CONCAT('%', :category, '%'))")
    List<Catalog> findByCategory(String category);

}
