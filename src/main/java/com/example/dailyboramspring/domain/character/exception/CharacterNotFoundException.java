package com.example.dailyboramspring.domain.character.exception;

import com.example.dailyboramspring.global.error.exception.ErrorCode;
import com.example.dailyboramspring.global.error.exception.GlobalException;

public class CharacterNotFoundException extends GlobalException {
    public static final CharacterNotFoundException EXCEPTION =
            new CharacterNotFoundException();

    public CharacterNotFoundException() {
        super(ErrorCode.CHARACTER_NOT_FOUND);
    }
}