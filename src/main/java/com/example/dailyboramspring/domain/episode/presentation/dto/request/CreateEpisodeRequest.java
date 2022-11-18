package com.example.dailyboramspring.domain.episode.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateEpisodeRequest {
    private String title;
    private Integer cost;
    private String image;
    private String imageContent;
}