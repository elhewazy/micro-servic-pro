package com.genspark.catalog_service.services;

import com.genspark.catalog_service.model.Book;
import com.genspark.catalog_service.model.Catalog;
import com.genspark.catalog_service.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatalogServiceImpl implements CatalogService{

    private CatalogRepository repository;
    private BookClient bookClient;

    // initialize repository and bookClient
    public CatalogServiceImpl(CatalogRepository catalogRepository, BookClient bookClient) {
        this.repository = catalogRepository ;
        this.bookClient = bookClient ;
    }

    // Return all the genres and their relative books
    @Override
    public List<Catalog> getAllCatalogs() {
        List<Catalog> catalogs = repository.findAll();
        List<Catalog> newCatalogs = catalogs.stream().map(catalog -> {
            catalog.setBooks(bookClient.getBookOfCatalog(catalog.getId()));
            return catalog;
        }).collect(Collectors.toList());

        return newCatalogs;
    }

    // Get catalog by their ID's
    @Override
    public Catalog getById(Long catalogId) {
        Optional<Catalog> t = this.repository.findById(catalogId);
        Catalog catalog = null;
        if (t.isPresent()) {
            catalog = t.get();
            catalog.setBooks(bookClient.getBookOfCatalog(catalogId));
        }
        return catalog;
    }

    @Override
    public List<Catalog> getByCatalog(String catalog) {
        return repository.findByCategory(catalog);
    }

    // Add catalog (genre)
    @Override
    public Catalog addCatalog(Catalog catalog) {
        return repository.save(catalog);
    }

    // delete a genre
    @Override
    public String deleteCatalog(Long catalogId) {
        repository.deleteById(catalogId);
        return "Deleted Catalog";
    }
    // update genre
    @Override
    public Catalog updateCatalog(Catalog catalog) {
        return repository.save(catalog);
    }
}

