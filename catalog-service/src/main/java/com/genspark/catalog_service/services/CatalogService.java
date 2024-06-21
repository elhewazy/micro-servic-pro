package com.genspark.catalog_service.services;

import com.genspark.catalog_service.model.Catalog;

import java.util.List;

public interface CatalogService {
    List<Catalog> getAllCatalogs();
    Catalog getById(Long catalogId);
    List<Catalog> getByCatalog(String catalog);
    Catalog addCatalog(Catalog catalog);
    String deleteCatalog(Long catalogId);
    Catalog updateCatalog(Catalog catalog);
}
