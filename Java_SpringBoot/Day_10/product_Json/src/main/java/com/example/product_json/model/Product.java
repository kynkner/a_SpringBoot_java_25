package com.example.product_json.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    static int auto_id = 1;
    String id;
    String name;
    String description;
    int price;
    String brand;

    public Product(String name, String description, int price, String brand) {
        this.id = String.valueOf(auto_id++);
        this.name = name;
        this.description = description;
        this.price = price;
        this.brand = brand;
    }
}
