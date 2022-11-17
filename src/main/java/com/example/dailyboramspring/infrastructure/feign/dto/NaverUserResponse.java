package com.example.dailyboramspring.infrastructure.feign.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NaverUserResponse {
    private String resultcode;
    private String message;
    private Response response;

    @Getter
    @AllArgsConstructor
    public static class Response {
        private String id;
        private String gender;
        private String email;
        private String age;
        private String moblie;
        private String moblieE164;
    }
}
