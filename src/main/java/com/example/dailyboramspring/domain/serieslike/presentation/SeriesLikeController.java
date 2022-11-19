package com.example.dailyboramspring.domain.serieslike.presentation;

import com.example.dailyboramspring.domain.serieslike.service.PostEpisodeLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/like")
@RestController
public class SeriesLikeController {

    private final PostEpisodeLikeService postEpisodeLikeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/episode/{episode_id}")
    public void postEpisodeLike(@PathVariable(name = "episode_id") Long episodeId) {
        postEpisodeLikeService.execute(episodeId);
    }
}
