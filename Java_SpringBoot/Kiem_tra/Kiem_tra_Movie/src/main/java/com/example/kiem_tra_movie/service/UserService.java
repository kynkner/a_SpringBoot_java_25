package com.example.kiem_tra_movie.service;

import com.example.kiem_tra_movie.entity.User;
import com.example.kiem_tra_movie.model.repository.UserRepository;
import com.example.kiem_tra_movie.request.PasswordRequest;
import com.example.kiem_tra_movie.request.ProfileUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
        private final UserRepository userRepository;

        public User getUserEmail (String email) {
            User user = userRepository.findByEmail(email);
            if (user == null) {
                throw new RuntimeException("User not found for email: " + email);
            }

            return user;
        }

        public void updateProfile (String email, ProfileUserRequest profileUserRequest) {
            User user = getUserEmail(email);
            if (user != null){
                user.setName(profileUserRequest.getName());
                user.setPhone(profileUserRequest.getPhone());
                userRepository.save(user);
            }
        }

        public Boolean updatePassword (String email, PasswordRequest passwordRequest){
            User user = getUserEmail(email);
            if(!user.getPassword().equals(passwordRequest.getPassword())){
                return false;
            }
            if(!passwordRequest.getConfirmPassword().equals(passwordRequest.getPassword())){
                return false;
            }
            user.setPassword(passwordRequest.getPassword());
            userRepository.save(user);
            return true;
        }
}
