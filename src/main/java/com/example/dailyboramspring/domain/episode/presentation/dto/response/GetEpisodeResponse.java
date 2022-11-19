package com.example.dailyboramspring.domain.episode.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class GetEpisodeResponse {
    private String image;
    private String title;
    private Long episodeNumber;
    private boolean isLike;
    private List<ContentList> contentList;

    @Getter
    @AllArgsConstructor
    @Builder
    public static final class ContentList {
        private Long id;
        private String image;
        private String name;
        private String line;
    }
}