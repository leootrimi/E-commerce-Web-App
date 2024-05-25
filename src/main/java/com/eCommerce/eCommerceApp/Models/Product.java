package com.eCommerce.eCommerceApp.Models;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    private String description;

    private MultipartFile file;

    private boolean available;

    @ManyToOne
    private Category category;

    // Constructors, getters, setters

    public Product() {
    }

    public Product(String name, double price, String description, MultipartFile file, boolean available, Category category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.file = file;
        this.available = available;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

