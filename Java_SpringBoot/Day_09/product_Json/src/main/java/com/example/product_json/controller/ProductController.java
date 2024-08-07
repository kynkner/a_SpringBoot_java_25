package com.example.product_json.controller;

import com.example.product_json.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
private List<Product> products = new ArrayList<>(List.of(
        new Product("iPhone 12", "The latest iPhone", 999, "Apple"),
        new Product("samsung 100", "Là điện thoại", 123123, "Samsung"),
        new Product("iPhone 34", "The latest iPhone", 123123, "Apple"),
        new Product("samsung 110", "Là điện thoại dùng được", 1234, "Samsung"),
        new Product("iPhone 524", "giống trên", 423424, "Apple"),
        new Product("samsung 134130", "Là điện thoại sử dụng bình thường", 3536, "Samsung"),
        new Product("realme 39", "Điện thoại có màn hình", 456457, "Oppo"),
        new Product("Readme 1124", "giống trên", 34226, "Xiaomi"),
        new Product("realme 1439", "Điện thoại sạc được", 4574567, "Oppo"),
        new Product("Readme 11", "là điện thoại cảm ứng", 54156165, "Xiaomi")
));

@GetMapping("/product")
    public List<Product> getAllProducts() {
    return products;
}

}
