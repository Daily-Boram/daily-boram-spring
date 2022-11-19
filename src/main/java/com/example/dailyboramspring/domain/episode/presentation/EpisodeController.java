package com.example.dailyboramspring.domain.episode.presentation;

import com.example.dailyboramspring.domain.episode.presentation.dto.request.CreateEpisodeRequest;
import com.example.dailyboramspring.domain.episode.presentation.dto.response.GetEpisodeResponse;
import com.example.dailyboramspring.domain.episode.service.CreateEpisodeService;
import com.example.dailyboramspring.domain.episode.service.GetEpisodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/episode")
public class EpisodeController {

    private final CreateEpisodeService createEpisodeService;
    private final GetEpisodeService getEpisodeService;

    @PostMapping("/{series-id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createEpisode(@PathVariable("series-id") Long seriesId, @RequestBody CreateEpisodeRequest request) {
        createEpisodeService.createEpisode(seriesId, request);
    }

    @GetMapping("/{episode-id}")
    public GetEpisodeResponse getEpisode(@PathVariable("episode-id") Long episodeId) {
        return getEpisodeService.getEpisode(episodeId);
    }
}