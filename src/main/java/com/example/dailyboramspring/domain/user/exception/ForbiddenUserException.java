package com.example.dailyboramspring.domain.user.exception;

import com.example.dailyboramspring.global.error.exception.ErrorCode;
import com.example.dailyboramspring.global.error.exception.GlobalException;

public class ForbiddenUserException extends GlobalException {
    public static final ForbiddenUserException EXCEPTION =
            new ForbiddenUserException();

    public ForbiddenUserException() {
        super(ErrorCode.FORBIDDEN_USER);
    }
}