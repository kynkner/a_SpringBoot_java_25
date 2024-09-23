package com.example.movieapp.repository;

import com.example.movieapp.entity.Blogs;
import com.example.movieapp.entity.Episodes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodesRepository extends JpaRepository<Episodes, Integer> {
}
