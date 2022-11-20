package com.example.dailyboramspring.domain.series.service;

import com.example.dailyboramspring.domain.genre.domain.Genre;
import com.example.dailyboramspring.domain.genre.facade.GenreFacade;
import com.example.dailyboramspring.domain.series.domain.repository.SeriesRepository;
import com.example.dailyboramspring.domain.series.facade.SeriesFacade;
import com.example.dailyboramspring.domain.series.presentation.dto.response.MainPageResponse;
import com.example.dailyboramspring.domain.series.presentation.dto.response.PopularListElement;
import com.example.dailyboramspring.domain.series.presentation.dto.response.SeriesListElement;
import com.example.dailyboramspring.domain.serieslike.facade.SeriesLikeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MainPageSeries {

    private final SeriesRepository seriesRepository;
    private final SeriesLikeFacade seriesLikeFacade;

    private final GenreFacade genreFacade;

    private final SeriesFacade seriesFacade;

    public MainPageResponse execute(String keyword) {
        Genre genre = genreFacade.findByGenre(keyword);

        List<SeriesListElement> seriesList = seriesFacade.getAllSeriesByGenre(genre)
                .stream()
                .map(series -> SeriesListElement.builder()
                        .id(series.getId())
                        .image(series.getImage())
                        .title(series.getTitle())
                        .nickname(series.getUser().getNickname())
                        .like(seriesLikeFacade.getCountBySeries(series))
                        .genre(genreFacade.findGenresBySeries(series))
                        .build()
                ).collect(Collectors.toList());

        List<PopularListElement> popularList = seriesRepository.findAllByOrderBySeriesLike()
                .stream()
                .map(series -> PopularListElement.builder()
                        .id(series.getId())
                        .image(series.getImage())
                        .summary(series.getSummary())
                        .nickname(series.getUser().getNickname())
                        .like(seriesLikeFacade.getCountBySeries(series))
                        .build()
                ).collect(Collectors.toList());

        return MainPageResponse.builder()
                .popularList(popularList)
                .seriesList(seriesList)
                .build();
    }
}
