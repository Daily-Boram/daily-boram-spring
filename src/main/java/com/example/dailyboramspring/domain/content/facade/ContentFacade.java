package com.example.dailyboramspring.domain.content.facade;

import com.example.dailyboramspring.domain.content.domain.Content;
import com.example.dailyboramspring.domain.content.domain.repository.ContentRepository;
import com.example.dailyboramspring.domain.episode.domain.Episode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ContentFacade {

    private final ContentRepository contentRepository;

    public List<Content> getContentsByEpisode(Episode episode) {
        return contentRepository.findAllByEpisode(episode);
    }
}