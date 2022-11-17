package com.example.dailyboramspring.infrastructure.feign.client;

import com.example.dailyboramspring.infrastructure.feign.dto.NaverUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "NaverGetClient", url = "https://openapi.naver.com/v1/nid/me")
public interface NaverGetClient {

    @GetMapping(produces = "application/json")
    NaverUserResponse get(@RequestHeader("Authorization") String accessToken);
}