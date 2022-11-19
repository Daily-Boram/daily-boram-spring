package com.example.dailyboramspring.domain.serieslike.presentation;

import com.example.dailyboramspring.domain.serieslike.service.DeleteSeriesLikeService;
import com.example.dailyboramspring.domain.serieslike.service.PostSeriesLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/like")
@RestController
public class SeriesLikeController {

    private final PostSeriesLikeService postSeriesLikeService;
    private final DeleteSeriesLikeService deleteSeriesLikeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/series/{series-id}")
    public void postSeriesLike(@PathVariable(name = "series-id") Long seriesId) {
        postSeriesLikeService.execute(seriesId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/series/{series-id}")
    public void deleteSeriesLike(@PathVariable(name = "series-id") Long seriesId) {
        deleteSeriesLikeService.execute(seriesId);
    }
}
