package com.example.dailyboramspring.domain.series.presentation;


import com.example.dailyboramspring.domain.series.presentation.dto.response.MainPageResponse;
import com.example.dailyboramspring.domain.series.service.MainPageSeries;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/main")
public class MainPageController {

    private final MainPageSeries mainPageSeries;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public MainPageResponse getMainPage(@RequestParam("genre") String genre) {
        return mainPageSeries.execute(genre);
    }
}
