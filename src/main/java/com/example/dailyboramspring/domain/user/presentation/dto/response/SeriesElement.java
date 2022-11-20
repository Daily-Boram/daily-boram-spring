package com.example.dailyboramspring.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SeriesElement {

    private String title;

    private String nickname;

    private String image;

    private Long like;
}