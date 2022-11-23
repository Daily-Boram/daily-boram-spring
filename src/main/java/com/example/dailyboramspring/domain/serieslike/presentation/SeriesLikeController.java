package com.example.dailyboramspring.domain.serieslike.presentation;

import com.example.dailyboramspring.domain.serieslike.service.DeleteSeriesLikeService;
import com.example.dailyboramspring.domain.serieslike.service.CreateSeriesLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/like")
@RestController
public class SeriesLikeController {

    private final CreateSeriesLikeService createSeriesLikeService;
    private final DeleteSeriesLikeService deleteSeriesLikeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/series/{series-id}")
    public void createSeriesLike(@PathVariable(name = "series-id") Long seriesId) {
        createSeriesLikeService.execute(seriesId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/series/{series-id}")
    public void deleteSeriesLike(@PathVariable(name = "series-id") Long seriesId) {
        deleteSeriesLikeService.execute(seriesId);
    }
}
