package com.example.movieapp.repository;

import com.example.movieapp.entity.Actors;
import com.example.movieapp.entity.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorsRepository extends JpaRepository<Actors, Integer> {
}
