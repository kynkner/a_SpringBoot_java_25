package com.example.miniproject_test.service.impl;

import com.example.miniproject_test.Dao.ProductDao;
import com.example.miniproject_test.model.Product;
import com.example.miniproject_test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productDao.findById(id);
    }

    @Override
    public List<Product> getProductsByName(String name) {
            return productDao.findAll().stream()
                    .filter(b -> b.getName().toLowerCase().contains(name.toLowerCase())).toList();

    }

}
