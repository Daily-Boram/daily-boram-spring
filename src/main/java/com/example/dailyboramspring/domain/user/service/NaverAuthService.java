package com.example.dailyboramspring.domain.user.service;

import com.example.dailyboramspring.domain.profile.domain.Profile;
import com.example.dailyboramspring.domain.profile.domain.repository.ProfileRepository;
import com.example.dailyboramspring.domain.user.domain.User;
import com.example.dailyboramspring.domain.user.domain.repository.UserRepository;
import com.example.dailyboramspring.domain.user.facade.UserFacade;
import com.example.dailyboramspring.domain.user.presentation.dto.response.TokenResponse;
import com.example.dailyboramspring.global.properties.NaverProperties;
import com.example.dailyboramspring.global.security.jwt.JwtTokenProvider;
import com.example.dailyboramspring.infrastructure.feign.client.NaverAuthClient;
import com.example.dailyboramspring.infrastructure.feign.client.NaverGetClient;
import com.example.dailyboramspring.infrastructure.feign.dto.NaverUserResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NaverAuthService {

    private final NaverAuthClient naverAuthClient;
    private final NaverGetClient naverGetClient;
    private final NaverProperties naverProperties;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final UserFacade userFacade;

    public TokenResponse get(String code) {

        String token = "Bearer " + naverAuthClient.naverAuth(
                naverProperties.getAuthorizationGrantType(),
                naverProperties.getClientId(),
                naverProperties.getClientSecret(),
                code
        ).getAccessToken();

        NaverUserResponse.Response response = naverGetClient.get(token).getResponse();

        if (!userRepository.existsByEmail(response.getEmail())) {
            userRepository.save(
                    User.builder()
                            .email(response.getEmail())
                            .gender(response.getGender())
                            .age(response.getAge())
                            .phoneNumber(response.getMobile())
                            .build()
            );

            profileRepository.save(
                    Profile.builder()
                            .Id(userFacade.getUserByEmail(response.getEmail()).getId())
                            .nickname(RandomStringUtils.randomAlphanumeric(8))

                            // 임시 Image link
                            .image("naver.com")
                            .cookie(0)
                            .build()
            );
        }
        String accessToken = jwtTokenProvider.generateAccessToken(response.getEmail());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .build();
    }
}