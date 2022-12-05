package com.example.dailyboramspring.domain.series.presentation;

import com.example.dailyboramspring.domain.series.presentation.dto.requset.CreateSeriesRequest;
import com.example.dailyboramspring.domain.series.presentation.dto.response.SeriesDetailResponse;
import com.example.dailyboramspring.domain.series.service.CreateSeries;
import com.example.dailyboramspring.domain.series.service.GetSeriesDetailService;
import com.example.dailyboramspring.domain.series.service.DeleteSeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/series")
public class SeriesController {

    private final CreateSeries createSeries;
    private final GetSeriesDetailService getSeriesDetailService;
    private final DeleteSeriesService deleteSeriesService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postSeries(@RequestBody CreateSeriesRequest request) {
        createSeries.execute(request);
    }

    @GetMapping("/{series-id}")
    @ResponseStatus(HttpStatus.OK)
    public SeriesDetailResponse getSeriesDetail(@PathVariable("series-id") Long seriesId, Pageable pageable) {
        return getSeriesDetailService.execute(seriesId, pageable);
    }

    @DeleteMapping("/{series-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSeries(@PathVariable("series-id") Long seriesId) {
        deleteSeriesService.execute(seriesId);
    }
}