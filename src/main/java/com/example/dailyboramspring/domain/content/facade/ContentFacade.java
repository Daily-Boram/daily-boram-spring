package com.example.dailyboramspring.domain.content.facade;

import com.example.dailyboramspring.domain.content.domain.Content;
import com.example.dailyboramspring.domain.content.domain.repository.ContentRepository;
import com.example.dailyboramspring.domain.episode.domain.Episode;
import com.example.dailyboramspring.domain.episode.domain.repository.EpisodeRepository;
import com.example.dailyboramspring.domain.series.domain.Series;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ContentFacade {

    private final ContentRepository contentRepository;
    private final EpisodeRepository episodeRepository;

    public List<Content> getContentsByEpisode(Episode episode) {
        return contentRepository.findAllByEpisode(episode);
    }

    public void deleteContent(Series series) {
        List<Episode> episodes = episodeRepository.findAllBySeries(series);

        for (Episode episode : episodes) {
            contentRepository.deleteAllByEpisode(episode);
        }
    }
}