package com.example.demoapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE) // Mặc định các trường private public protected
public class Book {
     int id;
     String title;
     String author;
     int year;
}
