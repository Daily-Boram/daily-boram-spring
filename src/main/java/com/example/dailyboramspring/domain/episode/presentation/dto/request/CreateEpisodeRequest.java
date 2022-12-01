package com.example.dailyboramspring.domain.episode.presentation.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CreateEpisodeRequest {
    private String title;
    private Integer cost;
    private String image;
    private String imageContent;
    private List<Character_list> character;
    private List<Content_list> content;

    @Getter
    @Builder
    public static class Character_list {
        private String image;
        private String name;
    }

    @Getter
    @Builder
    public static class Content_list {
        private String image;
        private String name;
        private String line;
    }
}