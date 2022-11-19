package com.example.dailyboramspring.domain.serieslike.exception;

import com.example.dailyboramspring.global.error.exception.ErrorCode;
import com.example.dailyboramspring.global.error.exception.GlobalException;

public class SeriesLikeNotFoundException extends GlobalException {
    public static final SeriesLikeNotFoundException EXCEPTION =
            new SeriesLikeNotFoundException();

    private SeriesLikeNotFoundException() {
        super(ErrorCode.SERIES_LIKE_NOT_FOUND);
    }
}
