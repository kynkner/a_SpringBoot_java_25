package com.example.demoapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;


@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE) // Mặc định các trường private public protected
public class Teacher {
    int id;
    String name;
}
