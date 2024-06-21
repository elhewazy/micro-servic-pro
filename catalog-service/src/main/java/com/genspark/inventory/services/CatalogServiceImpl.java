package com.genspark.inventory.services;

import com.genspark.inventory.model.Catalog;
import com.genspark.inventory.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogServiceImpl implements CatalogService{

    @Autowired
    CatalogRepository repository;
    @Override
    public List<Catalog> getAllCatalogs() {
        return repository.findAll();
    }

    @Override
    public Catalog getById(Long catalogId) {
        Optional<Catalog> t = this.repository.findById(catalogId);
        Catalog catalog = null;
        if (t.isPresent()) {
            catalog = t.get();
        }
        return catalog;
    }

    @Override
    public List<Catalog> getByCatalog(String catalog) {
        return repository.findByCategory(catalog);
    }

    @Override
    public Catalog addCatalog(Catalog catalog) {
        return repository.save(catalog);
    }

    @Override
    public String deleteCatalog(Long catalogId) {
        repository.deleteById(catalogId);
        return "Deleted Catalog";
    }

    @Override
    public Catalog updateCatalog(Catalog catalog) {
        return repository.save(catalog);
    }
}

