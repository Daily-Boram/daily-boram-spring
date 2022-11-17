package com.example.dailyboramspring.domain.user.presentation;

import com.example.dailyboramspring.domain.user.presentation.dto.response.TokenResponse;
import com.example.dailyboramspring.domain.user.service.NaverAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final NaverAuthService naverAuthService;

    @GetMapping("/login/oauth2/code/naver")
    public TokenResponse get(String code) {
        return naverAuthService.get(code);
    }
}