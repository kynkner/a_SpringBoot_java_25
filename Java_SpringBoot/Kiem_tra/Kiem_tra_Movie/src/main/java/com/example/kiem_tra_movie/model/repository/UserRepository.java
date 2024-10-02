package com.example.kiem_tra_movie.model.repository;

import com.example.kiem_tra_movie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
        User findByEmail (String email);

}
