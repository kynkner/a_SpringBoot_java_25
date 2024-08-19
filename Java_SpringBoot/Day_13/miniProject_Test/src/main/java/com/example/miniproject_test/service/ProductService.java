package com.example.miniproject_test.service;

import com.example.miniproject_test.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(int id);

    List<Product> getProductsByName(String name);
}
