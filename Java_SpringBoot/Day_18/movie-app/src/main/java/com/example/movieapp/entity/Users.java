package com.example.movieapp.entity;

import com.example.movieapp.model.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users") // ten bang
@ToString
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(unique = true)
    String name;

    String email;
    String avatar;

    @Column(unique = true)
    String password;

    @Enumerated(EnumType.STRING)
    UserRole role;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
