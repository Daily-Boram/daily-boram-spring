package com.example.dailyboramspring.domain.user.presentation.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class UpdateProfileRequest {

    @NotBlank
    @Size(max = 30)
    private String nickname;

    @NotBlank
    private String image;

    @NotBlank
    @Size(max = 100)
    private String introduce;

}
