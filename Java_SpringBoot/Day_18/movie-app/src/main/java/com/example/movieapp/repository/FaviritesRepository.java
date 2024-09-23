package com.example.movieapp.repository;

import com.example.movieapp.entity.Blogs;
import com.example.movieapp.entity.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaviritesRepository extends JpaRepository<Favorites, Integer> {
}
