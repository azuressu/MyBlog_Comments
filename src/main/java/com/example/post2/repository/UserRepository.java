package com.example.post2.repository;

import com.example.post2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> { // PK 값이 Username이기 때문

    Optional<User> findByUsername(String username);

}
