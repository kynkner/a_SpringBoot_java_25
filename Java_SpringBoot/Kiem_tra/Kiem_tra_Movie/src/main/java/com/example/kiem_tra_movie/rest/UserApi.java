package com.example.kiem_tra_movie.rest;

import com.example.kiem_tra_movie.request.PasswordRequest;
import com.example.kiem_tra_movie.request.ProfileUserRequest;
import com.example.kiem_tra_movie.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserApi {
        private UserService userService;

        @PutMapping("/update-profile")
        public String updateProfile(@RequestBody ProfileUserRequest profileUserRequest, HttpSession session) {
            String email = (String) session.getAttribute("email");
            userService.updateProfile(email, profileUserRequest);
            return "Cập nhật thành công";
        }

        @PutMapping("/update-password")
        public String updatePassword(@RequestBody PasswordRequest passwordRequest, HttpSession session) {
            String email = (String) session.getAttribute("email");
            boolean isUpdate = userService.updatePassword(email, passwordRequest);

            if (isUpdate) {
                return "Cập nhật mật khẩu thành công";
            }else{
                return "Cập nhật mật khẩu không thành công";
            }
        }
}
