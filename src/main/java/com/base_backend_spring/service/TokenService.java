package com.base_backend_spring.service;

import com.base_backend_spring.entity.RefreshToken;
import com.base_backend_spring.entity.User;

public interface TokenService {
    boolean validateAccessToken(String token);

    void initRefreshToken(User user);

    void clearToken(String userId);

    RefreshToken generateTokenObject(User user);
}
