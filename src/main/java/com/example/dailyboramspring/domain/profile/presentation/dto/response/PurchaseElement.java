package com.example.dailyboramspring.domain.profile.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PurchaseElement {

    private String seriesTitle;

    private String episodeTitle;

    private Integer cost;
}
