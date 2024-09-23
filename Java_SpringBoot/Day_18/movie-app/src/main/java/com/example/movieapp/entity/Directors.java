package com.example.movieapp.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "directors") // ten bang
@ToString
public class Directors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(unique = true, nullable = false)
    String name;

    @Column(unique = true, nullable = false)
    String slug;
    String avatar;

    @Column(columnDefinition = "text")
    String bio;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
