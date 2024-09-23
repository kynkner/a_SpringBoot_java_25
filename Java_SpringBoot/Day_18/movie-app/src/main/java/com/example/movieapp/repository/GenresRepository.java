package com.example.movieapp.repository;

import com.example.movieapp.entity.Blogs;
import com.example.movieapp.entity.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenresRepository extends JpaRepository<Genres, Integer> {
}
