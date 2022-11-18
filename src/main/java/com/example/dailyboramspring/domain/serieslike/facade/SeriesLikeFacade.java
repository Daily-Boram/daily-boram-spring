package com.example.dailyboramspring.domain.serieslike.facade;

import com.example.dailyboramspring.domain.series.domain.Series;
import com.example.dailyboramspring.domain.serieslike.domain.SeriesLikeId;
import com.example.dailyboramspring.domain.serieslike.domain.repository.SeriesLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SeriesLikeFacade {

    private final SeriesLikeRepository seriesLikeRepository;

    public Long getCountBySeries(Series series) {
        return seriesLikeRepository.countSeriesLikesBySeries(series);
    }
}
