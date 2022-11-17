package com.example.dailyboramspring.domain.user.exception;

import com.example.dailyboramspring.global.error.exception.ErrorCode;
import com.example.dailyboramspring.global.error.exception.GlobalException;

public class UserNotFoundException extends GlobalException {
    public static final UserNotFoundException EXCEPTION =
            new UserNotFoundException();

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}