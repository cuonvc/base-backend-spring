package com.base_backend_spring.service.impl;

import com.base_backend_spring.entity.RefreshToken;
import com.base_backend_spring.entity.User;
import com.base_backend_spring.repository.RefreshTokenRepository;
import com.base_backend_spring.security.jwt.JwtTokenProvider;
import com.base_backend_spring.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final JwtTokenProvider tokenProvider;
    private final RefreshTokenRepository repository;
    private static final long EXPIRE_DATE = 604800000; //mili-seconds

    @Override
    public boolean validateAccessToken(String token) {
        return tokenProvider.validateToken(token);
    }

    @Override
    public void initRefreshToken(User user) {
        RefreshToken refreshToken = RefreshToken.builder()
                .token("")
                .userId(user.getId())
                .build();

        repository.save(refreshToken);
    }

    @Override
    public void clearToken(String userId) {
        RefreshToken refreshToken = repository.findByUserId(userId).get();

        Date currentDate = new Date();
        Date expire = new Date(currentDate.getTime() - EXPIRE_DATE);

        refreshToken.setToken("");
        refreshToken.setExpireDate(expire);
        repository.save(refreshToken);
    }

    @Override
    public RefreshToken generateTokenObject(User user) {
        Date currentDate = new Date();
        Date expire = new Date(currentDate.getTime() + EXPIRE_DATE);
        Optional<RefreshToken> refreshToken = repository.findByUserId(user.getId());

        if (refreshToken.isEmpty()) {
            return null;
        }
        RefreshToken entity = refreshToken.get();
        entity.setToken("refresh_" + UUID.randomUUID());
        entity.setExpireDate(expire);
        return repository.save(entity);

    }
}
