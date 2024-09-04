package com.example.movieapp.service;

import com.example.movieapp.entity.Blogs;
import com.example.movieapp.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    public List<Blogs> getBlogsNew (int limit){
        Pageable pageable = PageRequest.of(0, limit, Sort.by("createdAt").descending());
        return blogRepository.findByStatus(true, pageable).getContent();
    }
}
