package com.example.movieapp.service;

import com.example.movieapp.entity.Blogs;
import com.example.movieapp.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    public Page<Blogs> getBlogs(Boolean status, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by("createdAt").descending());
        return blogRepository.findByStatus(status, pageable);
    }

    public Blogs getBlogDetails(Integer id, String slug) {
        return blogRepository.findByIdAndSlugAndStatus(id, slug, true)
                .orElse(null);
    }
}
