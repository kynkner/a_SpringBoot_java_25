package com.example.miniproject_test.Dao;

import com.example.miniproject_test.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();

    Product findById(int id);
}
