package com.example.movieapp.repository;

import com.example.movieapp.entity.Blogs;
import com.example.movieapp.entity.Users;
import com.example.movieapp.model.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository  extends JpaRepository<Users, Integer> {
    List<Users> findByRole(UserRole userRole);
}
