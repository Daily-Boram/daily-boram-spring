package com.example.dailyboramspring.domain.episode.facade;

import com.example.dailyboramspring.domain.episode.domain.Episode;
import com.example.dailyboramspring.domain.episode.domain.repository.EpisodeRepository;
import com.example.dailyboramspring.domain.episode.exception.EpisodeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EpisodeFacade {

    private final EpisodeRepository episodeRepository;

    public Episode getEpisodeById(Long id) {
        return episodeRepository.findById(id)
                .orElseThrow(() -> EpisodeNotFoundException.EXCEPTION);
    }
}
