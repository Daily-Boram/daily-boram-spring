package com.example.dailyboramspring.domain.profile.exception;

import com.example.dailyboramspring.global.error.exception.ErrorCode;
import com.example.dailyboramspring.global.error.exception.GlobalException;

public class UserNotFoundException extends GlobalException {
    public static final com.example.dailyboramspring.domain.user.exception.UserNotFoundException EXCEPTION =
            new com.example.dailyboramspring.domain.user.exception.UserNotFoundException();

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}