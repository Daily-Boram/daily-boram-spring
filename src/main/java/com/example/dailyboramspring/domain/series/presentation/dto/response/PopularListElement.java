package com.example.dailyboramspring.domain.series.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PopularListElement {

    private Long id;

    private String image;

    private String title;

    private String nickname;

    private String summary;

    private Long like;

}
