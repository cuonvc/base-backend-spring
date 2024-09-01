package com.base_backend_spring.service;

import com.base_backend_spring.payload.common.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface OAuthService {

    ResponseEntity<BaseResponse<Object>> validateGoogleToken(String token);
    ResponseEntity<BaseResponse<Object>> validateGithubCode(String code);
}
