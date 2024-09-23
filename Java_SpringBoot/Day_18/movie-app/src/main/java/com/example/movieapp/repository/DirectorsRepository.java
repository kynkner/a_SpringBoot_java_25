package com.example.movieapp.repository;

import com.example.movieapp.entity.Blogs;
import com.example.movieapp.entity.Directors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorsRepository extends JpaRepository<Directors, Integer> {
}
