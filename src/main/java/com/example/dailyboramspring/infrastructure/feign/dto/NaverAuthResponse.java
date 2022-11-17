package com.example.dailyboramspring.infrastructure.feign.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NaverAuthResponse {
    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private String expiresIn;
}