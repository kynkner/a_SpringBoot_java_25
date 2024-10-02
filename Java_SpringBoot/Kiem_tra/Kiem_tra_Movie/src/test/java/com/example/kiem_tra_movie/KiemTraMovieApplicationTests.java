package com.example.kiem_tra_movie;

import com.example.kiem_tra_movie.entity.User;
import com.example.kiem_tra_movie.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.nio.file.Files;
import java.security.Principal;
import java.util.List;

@SpringBootTest
class KiemTraMovieApplicationTests {

    @Autowired
    private UserRepository userRepository;




    @Test
    void contextLoads() {

        User user = User.builder()
                .name("nam")
                .password("123")
                .email("nam@mail.com")
                .phone("123456789")
                .build();
        userRepository.save(user);
    }

}
