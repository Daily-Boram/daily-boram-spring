package com.example.dailyboramspring.domain.series.presentation;

import com.example.dailyboramspring.domain.series.presentation.dto.requset.CreateSeriesRequest;
import com.example.dailyboramspring.domain.series.presentation.dto.response.SeriesDetailResponse;
import com.example.dailyboramspring.domain.series.service.CreateSeries;
import com.example.dailyboramspring.domain.series.service.GetSeriesDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/series")
public class SeriesController {

    private final CreateSeries createSeries;
    private final GetSeriesDetailService getSeriesDetailService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postSeries(@RequestBody CreateSeriesRequest request) {
        createSeries.execute(request);
    }

    @GetMapping("/{series-id}")
    @ResponseStatus
    public SeriesDetailResponse getSeriesDetail(@PathVariable("series-id") Long seriesId) {
        return getSeriesDetailService.execute(seriesId);
    }
}