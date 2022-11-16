package com.example.dailyboramspring.global.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "spring.security.oauth2.client.registration.naver")
public class NaverProperties {
    private final String clientId;
    private final String clientSecret;
    private final String authorizationGrantType;
}
