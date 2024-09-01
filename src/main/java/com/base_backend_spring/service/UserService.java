package com.base_backend_spring.service;

import com.base_backend_spring.payload.common.BaseResponse;
import com.base_backend_spring.payload.request.auth.LoginRequest;
import com.base_backend_spring.payload.request.auth.PasswordChangeRequest;
import com.base_backend_spring.payload.request.auth.RegRequest;
import com.base_backend_spring.payload.request.user.ProfileRequest;
import com.base_backend_spring.payload.response.user.PageResponseUsers;
import com.base_backend_spring.payload.response.user.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.Locale;

public interface UserService {
    ResponseEntity<BaseResponse<UserResponse>> register(RegRequest request, Locale locale);

    ResponseEntity<BaseResponse<Object>> signIn(LoginRequest request, Locale locale);

    ResponseEntity<BaseResponse<String>> signOut(Locale locale);

    ResponseEntity<BaseResponse<Object>> renewAccessToken(String refreshToken);

    ResponseEntity<BaseResponse<UserResponse>> editProfile(ProfileRequest request, Locale locale);

    ResponseEntity<BaseResponse<String>> changePassword(PasswordChangeRequest request, Locale locale);

    ResponseEntity<BaseResponse<UserResponse>> getAccount(Locale locale);

    ResponseEntity<BaseResponse<PageResponseUsers>> getAll(Integer pageNo, Integer pageSize, String sortBy, String sortDir, Locale locale);

    ResponseEntity<BaseResponse<UserResponse>> uploadAvatar(MultipartFile file, Locale locale) ;
}
