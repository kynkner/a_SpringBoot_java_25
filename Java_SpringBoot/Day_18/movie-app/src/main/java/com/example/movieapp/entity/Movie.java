package com.example.movieapp.entity;

import com.example.movieapp.model.enums.MovieType;
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
@Table(name = "movies") // ten bang
@ToString
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id tu dong
    Integer id;

    @Column(unique = true) // khong de trong
    String name;

    @Column(unique = true, nullable = false)
    String slug;

    @Column(columnDefinition = "text")
    String description;

    String poster;
    Integer releaseYear;
    Double rating;
    String trailerURL;

    @Enumerated(EnumType.STRING)
    MovieType type;

    Boolean status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    LocalDateTime publishedAt;
}
