package com.example.dailyboramspring.domain.genre.exception;

import com.example.dailyboramspring.domain.series.exception.SeriesNotFoundException;
import com.example.dailyboramspring.global.error.exception.ErrorCode;
import com.example.dailyboramspring.global.error.exception.GlobalException;

public class GenreNotFoundException extends GlobalException {
    public static final GenreNotFoundException EXCEPTION =
            new GenreNotFoundException();

    public GenreNotFoundException() {
        super(ErrorCode.SERIES_NOT_FOUND);
    }

}