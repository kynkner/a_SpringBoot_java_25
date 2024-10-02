package com.example.kiem_tra_movie.controller;

import com.example.kiem_tra_movie.entity.User;
import com.example.kiem_tra_movie.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;


@Controller
@RequiredArgsConstructor
public class WebController {
    private final UserService userService;

    @GetMapping("/thong-tin-ca-nhan")
    public String thongTinCaNhan(Model model, Principal principal) {
        String email = principal.getName();
        User user = userService.getUserEmail(email);
        model.addAttribute("user", user);
        return"index";


    }
}
