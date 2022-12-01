package com.example.dailyboramspring.domain.character.exception;

import com.example.dailyboramspring.global.error.exception.ErrorCode;
import com.example.dailyboramspring.global.error.exception.GlobalException;

public class CharacterExistsException extends GlobalException {
    public static final CharacterExistsException EXCEPTION =
            new CharacterExistsException();

    public CharacterExistsException() {
        super(ErrorCode.CHARACTER_ALREADY_EXISTS);
    }
}