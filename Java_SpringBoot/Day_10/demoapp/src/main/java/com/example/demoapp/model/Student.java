package com.example.demoapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE) // Mặc định các trường private public protected
public class Student {
    int id;
    String name;

    @Autowired
    Vehicle vehicle;

    public Student() {
        System.out.println("Student constructor");
    }
}
