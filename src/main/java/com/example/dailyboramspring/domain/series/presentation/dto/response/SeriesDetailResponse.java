package com.example.dailyboramspring.domain.series.presentation.dto.response;

import com.querydsl.core.annotations.QueryProjection;
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

    private List<String> genre;

    private List<EpisodeListElement> episodeLists;

    @QueryProjection
    public SeriesDetailResponse(String title, String image, String summary, String nickname, Long like, Boolean isLike, List<String> genre, List<EpisodeListElement> episodeLists) {
        this.title = title;
        this.image = image;
        this.summary = summary;
        this.nickname = nickname;
        this.like = like;
        this.isLike = isLike;
        this.genre = genre;
        this.episodeLists = episodeLists;
    }
}
