package com.example.dailyboramspring.domain.series.service;

import com.example.dailyboramspring.domain.genre.facade.GenreFacade;
import com.example.dailyboramspring.domain.series.facade.SeriesFacade;
import com.example.dailyboramspring.domain.series.presentation.dto.response.FeedListElement;
import com.example.dailyboramspring.domain.series.presentation.dto.response.SearchSeriesResponse;
import com.example.dailyboramspring.domain.serieslike.facade.SeriesLikeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SearchSeriesService {

    private final SeriesFacade seriesFacade;
    private final SeriesLikeFacade seriesLikeFacade;
    private final GenreFacade genreFacade;

    public SearchSeriesResponse execute(String title) {
        List<FeedListElement> feedList = seriesFacade.getAllSeriesByTitle(title)
                .stream()
                .map(series ->
                        FeedListElement.builder()
                                .id(series.getId())
                                .image(series.getImage())
                                .title(series.getTitle())
                                .nickname(series.getUser().getNickname())
                                .like(seriesLikeFacade.getCountBySeries(series))
                                .genre(genreFacade.findGenresBySeries(series))
                                .build()
                )
                .collect(Collectors.toList());

        return SearchSeriesResponse.builder()
                .feedList(feedList)
                .build();
    }
}