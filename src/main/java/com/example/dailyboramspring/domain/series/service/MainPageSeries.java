package com.example.dailyboramspring.domain.series.service;

import com.example.dailyboramspring.domain.genre.facade.GenreFacade;
import com.example.dailyboramspring.domain.series.domain.Series;
import com.example.dailyboramspring.domain.series.domain.repository.SeriesRepository;
import com.example.dailyboramspring.domain.series.presentation.dto.response.MainPageResponse;
import com.example.dailyboramspring.domain.series.presentation.dto.response.PopularListElement;
import com.example.dailyboramspring.domain.series.presentation.dto.response.SeriesListElement;
import com.example.dailyboramspring.domain.serieslike.facade.SeriesLikeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MainPageSeries {

    private final SeriesRepository seriesRepository;
    private final SeriesLikeFacade seriesLikeFacade;
    private final GenreFacade genreFacade;

    @Transactional(readOnly = true)
    public MainPageResponse execute(String genre, String sort) {

        List<SeriesListElement> seriesListElements;

        if (genre.isEmpty()) {
            seriesListElements = seriesRepository.queryAll(sort)
                    .stream()
                    .map(this::SeriesList)
                    .collect(Collectors.toList());
        } else {
            seriesListElements = seriesRepository.queryAll(genre, sort)
                    .stream()
                    .map(this::SeriesList)
                    .collect(Collectors.toList());
        }

        return MainPageResponse.builder()
                .seriesList(seriesListElements)
                .popularList(
                        seriesRepository.queryAll()
                                .stream()
                                .map(series -> PopularListElement.builder()
                                        .id(series.getId())
                                        .title(series.getTitle())
                                        .summary(series.getSummary())
                                        .nickname(series.getUser().getNickname())
                                        .image(series.getImage())
                                        .like(seriesLikeFacade.getCountBySeries(series))
                                        .build()
                                )
                                .collect(Collectors.toList())
                )
                .build();
    }
    
    private SeriesListElement SeriesList(Series series) {
        return SeriesListElement.builder()
                .id(series.getId())
                .title(series.getTitle())
                .image(series.getImage())
                .genre(genreFacade.findGenresBySeries(series))
                .like(seriesLikeFacade.getCountBySeries(series))
                .nickname(series.getUser().getNickname())
                .build();
    }
}