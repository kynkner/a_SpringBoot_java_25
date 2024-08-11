package com.example.demoapp.model;

import lombok.ToString;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@ToString
public class Bike  implements Vehicle {
    @Override
    public void run() {
        System.out.println("Bike is running");
    }
}
