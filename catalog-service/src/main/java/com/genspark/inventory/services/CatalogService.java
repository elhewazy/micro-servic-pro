package com.genspark.inventory.services;

import com.genspark.inventory.model.Catalog;

import java.util.List;

public interface CatalogService {
    List<Catalog> getAllCatalogs();
    Catalog getById(Long catalogId);
    List<Catalog> getByCatalog(String catalog);
    Catalog addCatalog(Catalog catalog);
    String deleteCatalog(Long catalogId);
    Catalog updateCatalog(Catalog catalog);
}
