package com.example.dailyboramspring.domain.episode.exception;

import com.example.dailyboramspring.global.error.exception.ErrorCode;
import com.example.dailyboramspring.global.error.exception.GlobalException;

public class EpisodeNotFoundException extends GlobalException {
    public static final EpisodeNotFoundException EXCEPTION =
            new EpisodeNotFoundException();

    public EpisodeNotFoundException() {
        super(ErrorCode.EPISODE_NOT_FOUND);
    }
}
