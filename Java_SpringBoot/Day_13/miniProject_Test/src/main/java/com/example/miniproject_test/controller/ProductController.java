package com.example.miniproject_test.controller;

import com.example.miniproject_test.database.ProductDB;
import com.example.miniproject_test.model.PageResponse;
import com.example.miniproject_test.model.PageResponseImpl;
import org.springframework.ui.Model;
import com.example.miniproject_test.model.Product;
import com.example.miniproject_test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/index")
    public String getAllProducts(Model model,
                                 @RequestParam(required = false, defaultValue = "1")int page,
                                 @RequestParam(required = false,defaultValue = "8") int size) {
        List<Product> products = productService.getAllProducts();
//        PageResponse<Product> pageResponse = PageResponseImpl.<Product>builder()
//                .currentPage(page)
//                .pageSize(size)
//                .data(products)
//                .build();

        model.addAttribute("products", products);
//        model.addAttribute("pageResponse", pageResponse);
        return "index";
    }

    @GetMapping("/index/products/{id}")
    public String getProductById(@PathVariable int id, Model model) {
        Product products = productService.getProductById(id);
        model.addAttribute("product", products);
        return "products-id";
    }
}
