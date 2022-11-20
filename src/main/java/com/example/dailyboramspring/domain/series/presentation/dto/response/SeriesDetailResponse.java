package com.example.dailyboramspring.domain.series.presentation.dto.response;

import com.example.dailyboramspring.domain.genre.domain.Genre;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class SeriesDetailResponse {

    private String title;

    private String image;

    private String summary;

    private String nickname;

    private Long like;

    private Boolean isLike;

    private List<Genre> genre;

    private List<EpisodeListElement> episodeLists;
}
