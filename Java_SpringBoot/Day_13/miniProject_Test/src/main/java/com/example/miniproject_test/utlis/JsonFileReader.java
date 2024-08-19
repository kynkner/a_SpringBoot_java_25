package com.example.miniproject_test.utlis;

import com.example.miniproject_test.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JsonFileReader implements IFileReader{

    @Override
    public List<Product> readFile(String path) {
        ObjectMapper mapper = new ObjectMapper();
        List<Product> products = new ArrayList<>();
        try {
            products = mapper.readValue(
                    new File(path),
                    new TypeReference<List<Product>>(){}
            );
        }catch (IOException e){
            e.printStackTrace();
        }
        return products;
    }
}
