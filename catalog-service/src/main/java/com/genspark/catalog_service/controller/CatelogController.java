package com.genspark.catalog_service.controller;

import com.genspark.catalog_service.model.Catalog;
import com.genspark.catalog_service.services.CatalogService;
import com.genspark.catalog_service.services.CatalogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogs")
public class CatelogController {
    private CatalogService service;


    public CatelogController(CatalogService service) { this.service = service ;}

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
