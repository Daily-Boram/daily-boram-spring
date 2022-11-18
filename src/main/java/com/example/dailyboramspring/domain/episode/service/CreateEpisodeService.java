package com.example.dailyboramspring.domain.episode.service;

import com.example.dailyboramspring.domain.episode.domain.Episode;
import com.example.dailyboramspring.domain.episode.domain.repository.EpisodeRepository;
import com.example.dailyboramspring.domain.episode.presentation.dto.request.CreateEpisodeRequest;
import com.example.dailyboramspring.domain.series.domain.Series;
import com.example.dailyboramspring.domain.series.facade.SeriesFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateEpisodeService {
    private final EpisodeRepository episodeRepository;
    private final SeriesFacade seriesFacade;

    public void createEpisode(Long seriesId, CreateEpisodeRequest request) {
        Series series = seriesFacade.findById(seriesId);

        episodeRepository.save(
                Episode.builder()
                        .title(request.getTitle())
                        .cost(request.getCost())
                        .image(request.getImage())
                        .series(series)
                        .build()
        );
    }
}