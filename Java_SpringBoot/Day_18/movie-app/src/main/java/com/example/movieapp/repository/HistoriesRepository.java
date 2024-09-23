package com.example.movieapp.repository;

import com.example.movieapp.entity.Blogs;
import com.example.movieapp.entity.Histories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoriesRepository extends JpaRepository<Histories, Integer> {
}
