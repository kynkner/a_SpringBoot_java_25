package com.example.product_json.controller;

import com.example.product_json.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class ProductController {
    private List<Product> products = new ArrayList<>(List.of(
            new Product("iPhone 12", "The latest iPhone", 999, "Apple"),
            new Product("samsung 100", "Là điện thoại", 123123, "Samsung"),
            new Product("iPhone 34", "The latest iPhone", 123123, "Apple"),
            new Product("samsung 110", "Là điện thoại dùng được", 1221312334, "Samsung"),
            new Product("iPhone 524", "giống trên", 423424, "Apple"),
            new Product("samsung 134130", "Là điện thoại sử dụng bình thường", 3536, "Samsung"),
            new Product("realme 39", "Điện thoại có màn hình", 456457, "Oppo"),
            new Product("Readme 1124", "giống trên", 34226, "Xiaomi"),
            new Product("realme 1439", "Điện thoại sạc được", 4574567, "Oppo"),
            new Product("Readme 11", "là điện thoại cảm ứng", 54156165, "Xiaomi")
    ));

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return products;
    }

    /*1. Lấy thông tin chi tiết của một sản phẩm
    API: GET /products/{id}
    Mô tả: Trả về chi tiết của sản phẩm dựa trên id được cung cấp.*/
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable String id) {
        for (Product product : products) {
            if (Objects.equals(product.getId(), id)) {
                return product;
            }
        }
        return null;
    }
/*2. Lấy sản phẩm với tên bắt đầu bằng prefix nào đó
API: GET /products/name-starts/{prefix}
Mô tả: Trả về danh sách sản phẩm có tên bắt đầu bằng nào đó.*/
@GetMapping("/products/name-starts/{prefix}")
    public ResponseEntity<List<Product>> getProductByName(@PathVariable String prefix) {
    List<Product> result =new ArrayList<>();
    for (Product product : products) {
        if(product.getName().toLowerCase().contains(prefix.toLowerCase())) {
            result.add(product);
        }
    }
    return ResponseEntity.ok(result);
}
/*3. Lọc sản phẩm theo khoảng giá
API: GET /products/price/{min}/{max}
Mô tả: Trả về danh sách sản phẩm có giá nằm trong khoảng từ min đến max.*/
@GetMapping("/products/price/{min}/{max}")
    public ResponseEntity<List<Product>> getProductByPrice(@PathVariable double min, @PathVariable double max) {
    List<Product> result = new ArrayList<>();
    for (Product product : products) {
        if(product.getPrice() >= min && product.getPrice() <= max) {
            result.add(product);
        }
    }
    return ResponseEntity.ok(result);
}

/*4. Lấy sản phẩm theo thương hiệu
API: GET /products/brand/{brand}
Mô tả: Trả về danh sách sản phẩm thuộc thương hiệu được chỉ định.*/
@GetMapping("/products/brand/{brand}")
    public ResponseEntity<List<Product>> getProductByBrand(@PathVariable String brand) {
    List<Product> result =new ArrayList<>();
    for (Product product : products) {
        if(product.getBrand().equalsIgnoreCase(brand)) {
            result.add(product);
        }
    }
    return ResponseEntity.ok(result);
}
/*5. Lấy sản phẩm có giá cao nhất
API: GET /products/brand/{brand}/max-price
Mô tả: Trả về sản phẩm có giá cao nhất theo brand được chỉ định.*/
    @GetMapping("/products/brand/{brand}/max-price")
    public Product getProductByBrandMaxPrice(@PathVariable String brand) {
        Product result = null;
        for (Product product : products) {
            if(product.getBrand().equalsIgnoreCase(brand)) {
                if(result == null || product.getPrice() > result.getPrice()) {
                    result = product;
                }
            }
        }
        return result;
    }
}


