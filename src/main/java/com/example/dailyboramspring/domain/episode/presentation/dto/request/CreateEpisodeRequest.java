package com.example.dailyboramspring.domain.episode.presentation.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@NoArgsConstructor
public class CreateEpisodeRequest {
    @NotBlank
    private String title;
    @NotNull
    private Integer cost;
    @NotBlank
    private String image;
    @NotNull
    private List<Character_list> character;
    @NotNull
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