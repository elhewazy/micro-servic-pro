package com.genspark.book_service.entities;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;

    @ElementCollection
    @CollectionTable(name = "book_catalog_ids", joinColumns = @JoinColumn(name = "book_id"))
    @Column(name = "catalog_id")
    private List<Long> catalogIds = new ArrayList<>();

    private Long customerId;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Long> getCatalogIds() {
        return catalogIds;
    }

    public void setCatalogIds(List<Long> catalogIds) {
        this.catalogIds = catalogIds;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
