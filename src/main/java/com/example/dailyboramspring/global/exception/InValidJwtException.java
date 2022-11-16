package com.example.dailyboramspring.global.exception;

import com.example.dailyboramspring.global.error.exception.ErrorCode;
import com.example.dailyboramspring.global.error.exception.GlobalException;

public class InValidJwtException extends GlobalException {
    public static final InValidJwtException EXCEPTION =
            new InValidJwtException();

    public InValidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}
