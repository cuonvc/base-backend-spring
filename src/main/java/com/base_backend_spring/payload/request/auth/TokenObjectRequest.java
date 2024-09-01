package com.base_backend_spring.payload.request.auth;

import lombok.Data;

@Data
public class TokenObjectRequest {
    private String refreshToken;
}
