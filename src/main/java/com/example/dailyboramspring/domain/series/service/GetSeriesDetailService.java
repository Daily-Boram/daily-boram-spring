package com.example.dailyboramspring.domain.series.service;

import com.example.dailyboramspring.domain.episode.domain.repository.EpisodeRepository;
import com.example.dailyboramspring.domain.episode.facade.EpisodeFacade;
import com.example.dailyboramspring.domain.genre.domain.repository.GenreRepository;
import com.example.dailyboramspring.domain.genre.facade.GenreFacade;
import com.example.dailyboramspring.domain.series.domain.Series;
import com.example.dailyboramspring.domain.series.facade.SeriesFacade;
import com.example.dailyboramspring.domain.series.presentation.dto.response.EpisodeListElement;
import com.example.dailyboramspring.domain.series.presentation.dto.response.SeriesDetailResponse;
import com.example.dailyboramspring.domain.serieslike.facade.SeriesLikeFacade;
import com.example.dailyboramspring.domain.user.domain.User;
import com.example.dailyboramspring.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetSeriesDetailService {

    private final SeriesFacade seriesFacade;
    private final SeriesLikeFacade seriesLikeFacade;
    private final EpisodeRepository episodeRepository;
    private final GenreFacade genreFacade;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public SeriesDetailResponse execute(Long seriesId, Pageable pageable) {
        User user = userFacade.getCurrentUser();
        Series series = seriesFacade.findById(seriesId);

        List<EpisodeListElement> episodeLists = episodeRepository.queryAllEpisodePaging(series, pageable)
                .stream()
                .map(episode -> EpisodeListElement.builder()
                        .id(episode.getId())
                        .title(episode.getTitle())
                        .cost(episode.getCost())
                        .image(episode.getImage())
                        .createdAt(episode.getSeries().getCreatedAt())
                        .build()
                ).collect(Collectors.toList());

        return SeriesDetailResponse
                .builder()
                .title(series.getTitle())
                .image(series.getImage())
                .like(seriesLikeFacade.getCountBySeries(series))
                .nickname(series.getUser().getNickname())
                .isLike(seriesLikeFacade.existsSeriesLike(user, series))
                .genre(genreFacade.findGenresBySeries(series))
                .episodeLists(episodeLists)
                .build();
    }
}