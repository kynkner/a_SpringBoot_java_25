package com.example.miniproject_test.Dao.impl;

import com.example.miniproject_test.Dao.ProductDao;
import com.example.miniproject_test.database.ProductDB;
import com.example.miniproject_test.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> findAll() {
        return ProductDB.products.stream().toList();
    }

    @Override
    public Product findById(int id) {
        return ProductDB.products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
