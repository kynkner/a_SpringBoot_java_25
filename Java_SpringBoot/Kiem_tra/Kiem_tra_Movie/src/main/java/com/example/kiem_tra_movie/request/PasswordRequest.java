package com.example.kiem_tra_movie.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PasswordRequest {
    String password;
    String newPassword;
    String confirmPassword;
}
