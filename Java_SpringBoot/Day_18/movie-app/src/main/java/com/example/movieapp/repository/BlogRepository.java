package com.example.movieapp.repository;


import com.example.movieapp.entity.Blogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogRepository extends JpaRepository<Blogs, Integer> {
    Page<Blogs> findByStatus(Boolean status, Pageable pageable);

    Optional<Blogs> findByIdAndSlugAndStatus(Integer id, String slug, Boolean status);


}
