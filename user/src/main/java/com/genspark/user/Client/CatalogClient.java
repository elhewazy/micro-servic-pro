package com.genspark.user.Client;

import com.genspark.user.Entity.Catalog;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface CatalogClient {

    @GetExchange("/catalogs/")
    public List<Catalog> findAllCatalogs();
}
