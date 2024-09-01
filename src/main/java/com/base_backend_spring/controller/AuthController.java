package com.base_backend_spring.controller;

import com.base_backend_spring.payload.common.BaseResponse;
import com.base_backend_spring.payload.request.auth.LoginRequest;
import com.base_backend_spring.payload.request.auth.RegRequest;
import com.base_backend_spring.payload.response.user.UserResponse;
import com.base_backend_spring.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<BaseResponse<UserResponse>> signUp(@RequestHeader(value = "Accept-Language") Locale locale,
                                                             @Valid @RequestBody RegRequest request) {
        return userService.register(request, locale);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<BaseResponse<Object>> signIn(@RequestHeader(value = "Accept-Language") Locale locale,
                                                                     @Valid @RequestBody LoginRequest request) {
        return userService.signIn(request, locale);
    }

    @PostMapping("/sign-out")
    public ResponseEntity<BaseResponse<String>> signOut(@RequestHeader(value = "Accept-Language") Locale locale) {
        return userService.signOut(locale);
    }

    @GetMapping("/token/renew")
    public ResponseEntity<BaseResponse<Object>> renewAccessToken(@RequestParam("refresh_token") String refreshToken) {
        return userService.renewAccessToken(refreshToken);
    }
}
