package com.example.kiem_tra_movie;

import com.example.kiem_tra_movie.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KiemTraMovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(KiemTraMovieApplication.class, args);

        User user = new User();
            System.out.println(user);

    }

}
