package com.base_backend_spring.service.impl;

import com.base_backend_spring.entity.User;
import com.base_backend_spring.exception.ServiceException;
import com.base_backend_spring.payload.enumerate.ErrorCode;
import com.base_backend_spring.repository.UserRepository;
import com.base_backend_spring.security.CustomUserDetail;
import com.base_backend_spring.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

import static com.base_backend_spring.payload.enumerate.ErrorCode.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CommonServiceImpl implements CommonService {

    private final MessageSource messageSource;
    private final UserRepository userRepository;

    @Override
    public CustomUserDetail getCurrentUser() {
        return (CustomUserDetail) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
    }

    @Override
    public String getCurrentUserId() {
        return getCurrentUser().getId();
    }

    @Override
    public String getMessageSrc(String messageCode, Locale locale) {
        return messageSource.getMessage(messageCode, null, locale);
    }

    @Override
    public void throwException(ErrorCode errorCode, Locale locale, Object... args) {
        throw new ServiceException(
                messageSource.getMessage(errorCode.getMessageCode(), null, locale),
                errorCode.getStatus(),
                errorCode.getStatusCode(),
                args
        );
    }

    @Override
    public User findUserByIdOrThrow(String id, Locale locale) {
        Optional<User> userOp = userRepository.findById(id);
        if (userOp.isEmpty()) {
            this.throwException(USER_NOT_FOUND, locale);
        }

        return userOp.get();
    }

    @Override
    public User findUserByEmailOrThrow(String email, Locale locale) {
        Optional<User> userOp = userRepository.findByEmail(email);
        if (userOp.isEmpty()) {
            this.throwException(USER_NOT_FOUND, locale, email);
        }

        return userOp.get();
    }
}
