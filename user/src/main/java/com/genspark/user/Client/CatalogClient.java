package com.genspark.user.Client;

import com.genspark.user.Entity.Catalog;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.*;

import java.util.List;

@HttpExchange
public interface CatalogClient {

    @GetExchange("/catalogs")
    List<Catalog> findAllCatalogs();

    @PostExchange("/catalogs")
    Catalog addNewCatalog(@RequestBody Catalog catalog);

    @PutExchange("/catalogs")
    Catalog updateCatalog(@RequestBody Catalog catalog);

    @DeleteExchange("/catalogs/{id}")
    String deleteCatalog(@PathVariable long id);
}
