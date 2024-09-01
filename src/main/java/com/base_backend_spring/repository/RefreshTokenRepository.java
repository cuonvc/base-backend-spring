package com.base_backend_spring.repository;

import com.base_backend_spring.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {

    Optional<RefreshToken> findByUserId(String userId);

    Optional<RefreshToken> findByToken(String token);
}
