package com.example.dailyboramspring.domain.serieslike.facade;

import com.example.dailyboramspring.domain.series.domain.Series;
import com.example.dailyboramspring.domain.serieslike.domain.SeriesLike;
import com.example.dailyboramspring.domain.serieslike.domain.repository.SeriesLikeRepository;
import com.example.dailyboramspring.domain.serieslike.exception.SeriesLikeNotFoundException;
import com.example.dailyboramspring.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SeriesLikeFacade {

    private final SeriesLikeRepository seriesLikeRepository;

    public Long getCountBySeries(Series series) {
        return seriesLikeRepository.countSeriesLikesBySeries(series);
    }

    public Boolean existsSeriesLike(User user, Series series){
        return seriesLikeRepository.existsSeriesLikeByUserAndSeries(user, series);
    }
    public SeriesLike getSeriesLike(User user, Series series) {
        return seriesLikeRepository.findSeriesLikeByUserAndSeries(user, series)
                .orElseThrow(() -> SeriesLikeNotFoundException.EXCEPTION);
    }
}
