package com.example.dailyboramspring.domain.episode.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ContentListElement {
    private Long id;
    private String image;
    private String name;
    private String line;
}