package com.example.miniproject_test.database;

import com.example.miniproject_test.model.Product;
import com.example.miniproject_test.utlis.IFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
public class InitDB implements CommandLineRunner {

    @Autowired
    private IFileReader fileReader;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("InitDB.run...");

        ProductDB.products = fileReader.readFile("product.json");
        System.out.println(ProductDB.products.size());
    }


}
