package com.example.dailyboramspring.domain.content.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class CreateContentRequest {

    @NotBlank(message = "대사를 추가해 주세요")
    private String line;
}