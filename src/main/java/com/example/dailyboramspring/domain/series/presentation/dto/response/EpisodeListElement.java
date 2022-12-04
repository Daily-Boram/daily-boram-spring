package com.example.dailyboramspring.domain.series.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class EpisodeListElement {

    private Long id;

    private String image;

    private String title;

    private Integer cost;

    private LocalDateTime createdAt;

    private Integer like;

}
