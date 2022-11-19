package com.example.dailyboramspring.domain.episodelike.exception;

import com.example.dailyboramspring.global.error.exception.ErrorCode;
import com.example.dailyboramspring.global.error.exception.GlobalException;

public class EpisodeLikeNotFoundException extends GlobalException {
    public static final EpisodeLikeNotFoundException EXCEPTION =
            new EpisodeLikeNotFoundException();

    public EpisodeLikeNotFoundException() {
        super(ErrorCode.EPISODE_LIKE_NOT_FOUND);
    }
}
