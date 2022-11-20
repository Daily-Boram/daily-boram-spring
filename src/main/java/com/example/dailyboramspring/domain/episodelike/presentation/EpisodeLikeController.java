package com.example.dailyboramspring.domain.episodelike.presentation;

import com.example.dailyboramspring.domain.episodelike.service.DeleteEpisodeLikeService;
import com.example.dailyboramspring.domain.episodelike.service.PostEpisodeLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/like")
@RestController
public class EpisodeLikeController {

    private final PostEpisodeLikeService postEpisodeLikeService;
    private final DeleteEpisodeLikeService deleteEpisodeLikeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/episode/{episode-id}")
    public void postEpisodeLike(@PathVariable(name = "episode-id") Long episodeId) {
        postEpisodeLikeService.execute(episodeId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/episode/{episode-id}")
    public void deleteEpisodeLike(@PathVariable(name = "episode-id") Long episodeId) {
        deleteEpisodeLikeService.execute(episodeId);
    }
}
