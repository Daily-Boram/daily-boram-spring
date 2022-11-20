package com.example.dailyboramspring.domain.series.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MainPageResponse {
    private List<PopularListElement> popularList;

    private List<SeriesListElement> seriesList;
}
