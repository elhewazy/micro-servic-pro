package com.genspark.inventory.repository;

import com.genspark.inventory.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long> {

    @Query("SELECT c from Catalog c WHERE LOWER(c.category) LIKE LOWER(CONCAT('%', :category, '%'))")
    List<Catalog> findByCategory(String category);

}
