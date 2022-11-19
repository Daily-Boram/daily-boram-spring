package com.example.dailyboramspring.domain.series.presentation;

import com.example.dailyboramspring.domain.series.domain.repository.SeriesRepository;
import com.example.dailyboramspring.domain.series.presentation.dto.requset.CreateSeriesRequest;
import com.example.dailyboramspring.domain.series.service.CreateSeries;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/series")
public class SeriesController {

    private final CreateSeries createSeries;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postSeries(@RequestBody CreateSeriesRequest request) {
        createSeries.execute(request);
    }
}