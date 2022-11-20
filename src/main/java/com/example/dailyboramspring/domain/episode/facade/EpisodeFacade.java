package com.example.dailyboramspring.domain.episode.facade;

import com.example.dailyboramspring.domain.episode.domain.Episode;
import com.example.dailyboramspring.domain.episode.domain.repository.EpisodeRepository;
import com.example.dailyboramspring.domain.episode.exception.EpisodeNotFoundException;
import com.example.dailyboramspring.domain.series.domain.Series;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class EpisodeFacade {

    private final EpisodeRepository episodeRepository;

    public Episode getEpisodeById(Long id) {
        return episodeRepository.findById(id)
                .orElseThrow(() -> EpisodeNotFoundException.EXCEPTION);
    }

    public List<Episode> getEpisodeBySeries(Series series){
        return episodeRepository.findAllBySeries(series);

    }
}
