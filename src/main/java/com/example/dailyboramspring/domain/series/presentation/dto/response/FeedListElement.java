package com.example.dailyboramspring.domain.series.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class FeedListElement {

    private Long id;

    private String image;

    private String title;

    private String nickname;

    private Integer like;

    private List<String> genre;
}