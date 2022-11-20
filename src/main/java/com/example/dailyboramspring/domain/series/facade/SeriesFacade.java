package com.example.dailyboramspring.domain.series.facade;

import com.example.dailyboramspring.domain.genre.domain.Genre;
import com.example.dailyboramspring.domain.genre.domain.repository.GenreRepository;
import com.example.dailyboramspring.domain.series.domain.Series;
import com.example.dailyboramspring.domain.series.domain.repository.SeriesRepository;
import com.example.dailyboramspring.domain.series.exception.SeriesNotFoundException;
import com.example.dailyboramspring.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class SeriesFacade {

    private final SeriesRepository seriesRepository;

    public Series findById(Long seriesId) {
        return seriesRepository.findById(seriesId)
                .orElseThrow(() -> SeriesNotFoundException.EXCEPTION);
    }

    public List<Series> GetAllSeriesByUser(User user) {
        return seriesRepository.findAllByUser(user);
    }

    public List<Series> getAllSeriesByTitle(String title) {
        return seriesRepository.findAllByTitleContaining(title);
    }

    public List<Series> getAllSeriesByGenre(Genre genre) {
        return seriesRepository.findAllByGenreContaining(genre);
    }

}