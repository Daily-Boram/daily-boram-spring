package com.example.dailyboramspring.domain.comment.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class CreateCommentRequest {

    @NotBlank(message = "내용을 입력해주세요.")
    private String content;
}
