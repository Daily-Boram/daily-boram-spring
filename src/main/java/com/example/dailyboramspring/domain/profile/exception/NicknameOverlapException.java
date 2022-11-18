package com.example.dailyboramspring.domain.profile.exception;

import com.example.dailyboramspring.global.error.exception.ErrorCode;
import com.example.dailyboramspring.global.error.exception.GlobalException;

public class NicknameOverlapException extends GlobalException {

    public static final NicknameOverlapException EXCEPTION =
            new NicknameOverlapException();

    public NicknameOverlapException() {
        super(ErrorCode.USER_NAME_ALREADY_EXISTS);
    }
}
