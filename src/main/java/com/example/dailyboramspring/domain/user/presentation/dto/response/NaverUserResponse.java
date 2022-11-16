package com.example.dailyboramspring.domain.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class NaverUserResponse {
    private String name;
    private String gender;
    private String age;
    private String birthDay;
    private String birthYear;
    private String email;
    private String phoneNumber;
}