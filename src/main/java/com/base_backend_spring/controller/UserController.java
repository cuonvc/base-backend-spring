package com.base_backend_spring.controller;

import com.base_backend_spring.payload.common.BaseResponse;
import com.base_backend_spring.payload.request.auth.PasswordChangeRequest;
import com.base_backend_spring.payload.request.user.ProfileRequest;
import com.base_backend_spring.payload.response.user.PageResponseUsers;
import com.base_backend_spring.payload.response.user.UserResponse;
import com.base_backend_spring.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Locale;

import static com.base_backend_spring.util.Constant.PageConstant.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PutMapping("/account/edit")
    public ResponseEntity<BaseResponse<UserResponse>> editProfile(@RequestHeader(value = "Accept-Language") Locale locale,
                                                                  @Valid @RequestBody ProfileRequest request) {
        return userService.editProfile(request, locale);
    }

    @PutMapping("/password-change")
    public ResponseEntity<BaseResponse<String>> changePassword(@RequestHeader(value = "Accept-Language") Locale locale,
                                                               @Valid @RequestBody PasswordChangeRequest request) {
        return userService.changePassword(request, locale);
    }

    @GetMapping("/account")
    public ResponseEntity<BaseResponse<UserResponse>> getProfile(@RequestHeader(value = "Accept-Language") Locale locale) {
        return userService.getAccount(locale);
    }

    @GetMapping("/moderator/account-list")
    public ResponseEntity<BaseResponse<PageResponseUsers>> getAllAccount(@RequestHeader(value = "Accept-Language") Locale locale,
                                                                         @RequestParam(value = "pageNo",
                                                                                defaultValue = PAGE_NO, required = false) Integer pageNo,
                                                                         @RequestParam(value = "pageSize",
                                                                                 defaultValue = PAGE_SIZE, required = false) Integer pageSize,
                                                                         @RequestParam(value = "sortBy",
                                                                                 defaultValue = SORT_BY, required = false) String sortBy,
                                                                         @RequestParam(value = "sortDir",
                                                                                 defaultValue = SORT_DIR, required = false) String sortDir) {
        return userService.getAll(pageNo, pageSize, sortBy, sortDir, locale);
    }

    @PutMapping("/account/avatar")
    public ResponseEntity<BaseResponse<UserResponse>> uploadAvatar(@RequestHeader(value = "Accept-Language") Locale locale,
                                                                   @RequestPart(name = "image") MultipartFile file) {
        return userService.uploadAvatar(file, locale);
    }
}
