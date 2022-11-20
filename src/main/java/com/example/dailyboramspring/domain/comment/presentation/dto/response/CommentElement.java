package com.example.dailyboramspring.domain.comment.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentElement {
    private Long id;
    private String image;
    private String nickname;
    private String content;
}
