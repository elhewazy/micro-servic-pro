package com.genspark.catalog_service.controller;

import com.genspark.catalog_service.model.Catalog;
import com.genspark.catalog_service.services.CatalogService;
import com.genspark.catalog_service.services.CatalogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogs")
public class CatelogController {
    private final CatalogService service;


    public CatelogController(CatalogService service) { this.service = service ;}
    @PostMapping
    public ResponseEntity<Catalog> add(@RequestBody Catalog catalog) {
        Catalog createdCatalog = service.addCatalog(catalog);
        return ResponseEntity.status(201).body(createdCatalog);
    }

    @GetMapping
    public ResponseEntity<List<Catalog>> findAll(){
        return ResponseEntity.ok(service.getAllCatalogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Catalog> findById(@PathVariable Long id){
        Catalog catalog = service.getById(id);
        return catalog != null ? ResponseEntity.ok(catalog) : ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<Catalog> update(@RequestBody Catalog catalog){
        return ResponseEntity.ok(service.updateCatalog(catalog));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.deleteCatalog(id));
    }
}
