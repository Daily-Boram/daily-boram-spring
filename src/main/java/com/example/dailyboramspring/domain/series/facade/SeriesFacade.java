package com.example.dailyboramspring.domain.series.facade;

import com.example.dailyboramspring.domain.series.domain.Series;
import com.example.dailyboramspring.domain.series.domain.repository.SeriesRepository;
import com.example.dailyboramspring.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class SeriesFacade {

    private final SeriesRepository seriesRepository;

    public List<Series> GetAllSeriesByUser(User user) {
        return seriesRepository.findAllByUser(user);
    }
}
