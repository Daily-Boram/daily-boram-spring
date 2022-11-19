package com.example.dailyboramspring.domain.character.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class CreateCharacterRequest {

    @NotBlank(message = "이미지를 꼭 넣어주세요")
    private String image;

    @NotBlank(message = "캐릭터 이름을 정해주세요")
    private String name;
}