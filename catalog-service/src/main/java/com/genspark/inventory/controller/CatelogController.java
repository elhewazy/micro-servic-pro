package com.genspark.inventory.controller;

import com.genspark.inventory.model.Catalog;
import com.genspark.inventory.repository.CatalogRepository;
import com.genspark.inventory.services.CatalogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class CatelogController {
    @Autowired
    private CatalogServiceImpl service;

//    @Autowired
//    private BookClient bookClient;

    @PostMapping
    public Catalog add(@RequestBody Catalog catalog){
        return service.addCatalog(catalog);
    }

    @GetMapping
    public List<Catalog> findAll(){
        return service.getAllCatalogs();
    }

    @GetMapping("/{id}")
    public Catalog findById(Long id){
        return service.getById(id);
    }

    @PutMapping
    public Catalog update(@RequestBody Catalog catalog){
        return service.updateCatalog(catalog);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return service.deleteCatalog(id);
    }
}
