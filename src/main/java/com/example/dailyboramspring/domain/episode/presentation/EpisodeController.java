package com.example.dailyboramspring.domain.episode.presentation;

import com.example.dailyboramspring.domain.episode.presentation.dto.request.CreateEpisodeRequest;
import com.example.dailyboramspring.domain.episode.service.CreateEpisodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/episode")
public class EpisodeController {

    private final CreateEpisodeService createEpisodeService;

    @PostMapping("/{series-id}")
    public void createEpisode(@PathVariable("series-id") Long seriesId, @RequestBody CreateEpisodeRequest request) {
        createEpisodeService.createEpisode(seriesId, request);
    }
}