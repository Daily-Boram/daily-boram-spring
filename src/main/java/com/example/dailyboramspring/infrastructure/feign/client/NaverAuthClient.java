package com.example.dailyboramspring.infrastructure.feign.client;

import com.example.dailyboramspring.infrastructure.feign.dto.NaverAuthResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "NaverAuthClient", url = "https://nid.naver.com/oauth2.0/token")
public interface NaverAuthClient {

    @GetMapping(produces = "application/json")
    NaverAuthResponse naverAuth(
            @RequestParam(value = "grant_type") String grantType,
            @RequestParam(value = "client_id") String clientId,
            @RequestParam(value = "client_secret") String clientSecret,
            @RequestParam(value = "code") String code
    );
}
