package com.example.miniproject_test.utlis;

import com.example.miniproject_test.model.Product;

import java.util.List;

@FunctionalInterface
public interface IFileReader {
    List<Product> readFile(String path);
}
