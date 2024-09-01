package com.base_backend_spring.service;

import com.base_backend_spring.entity.User;
import com.base_backend_spring.payload.enumerate.ErrorCode;
import com.base_backend_spring.security.CustomUserDetail;

import java.util.Locale;

public interface CommonService {
    CustomUserDetail getCurrentUser();
    String getCurrentUserId();
    String getMessageSrc(String messageCode, Locale locale);
    void throwException(ErrorCode errorCode, Locale locale, Object... args);
    User findUserByIdOrThrow(String id, Locale locale);
    User findUserByEmailOrThrow(String email, Locale locale);
}
