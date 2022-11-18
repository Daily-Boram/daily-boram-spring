package com.example.dailyboramspring.domain.series.exception;

import com.example.dailyboramspring.global.error.exception.ErrorCode;
import com.example.dailyboramspring.global.error.exception.GlobalException;

public class SeriesNotFoundException extends GlobalException {
    public static final SeriesNotFoundException EXCEPTION =
            new SeriesNotFoundException();

    public SeriesNotFoundException() {
        super(ErrorCode.SERIES_NOT_FOUND);
    }
}
