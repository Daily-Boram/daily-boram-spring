package com.example.dailyboramspring.domain.series.presentation;

import com.example.dailyboramspring.domain.series.presentation.dto.response.SearchSeriesResponse;
import com.example.dailyboramspring.domain.series.service.SearchSeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchSeriesController {

    private final SearchSeriesService searchSeriesService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public SearchSeriesResponse searchSeries(@RequestParam(value = "title") String title) {
        return searchSeriesService.execute(title);
    }
}