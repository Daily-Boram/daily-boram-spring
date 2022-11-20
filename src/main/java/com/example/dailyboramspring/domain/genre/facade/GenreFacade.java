package com.example.dailyboramspring.domain.genre.facade;

import com.example.dailyboramspring.domain.genre.domain.Genre;
import com.example.dailyboramspring.domain.genre.domain.repository.GenreRepository;
import com.example.dailyboramspring.domain.genre.exception.GenreNotFoundException;
import com.example.dailyboramspring.domain.series.domain.Series;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class GenreFacade {

    private final GenreRepository genreRepository;

    public List<String> findGenresBySeries(Series series) {
        return genreRepository.findAllBySeries(series)
                .stream()
                .map(Genre::getGenre)
                .collect(Collectors.toList());
    }

    public Genre findByGenre(String keyword) {
        return genreRepository.findByGenre(keyword)
                .orElseThrow(() -> GenreNotFoundException.EXCEPTION);
    }
}