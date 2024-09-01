package com.base_backend_spring.repository;

import com.base_backend_spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.status != 'INACTIVE'")
    Optional<User> findByEmail(String email);
}
