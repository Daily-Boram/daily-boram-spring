package com.example.dailyboramspring.domain.comment.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetCommentResponse {
    private List<CommentElement> commentsList;
}
