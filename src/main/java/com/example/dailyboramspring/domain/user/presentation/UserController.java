package com.example.dailyboramspring.domain.user.presentation;

import com.example.dailyboramspring.domain.user.presentation.dto.request.UpdateProfileRequest;
import com.example.dailyboramspring.domain.user.presentation.dto.response.MyUserProfileResponse;
import com.example.dailyboramspring.domain.user.presentation.dto.response.TokenResponse;
import com.example.dailyboramspring.domain.user.presentation.dto.response.UserProfileResponse;
import com.example.dailyboramspring.domain.user.service.GetMyUserProfileService;
import com.example.dailyboramspring.domain.user.service.GetUserProfileService;
import com.example.dailyboramspring.domain.user.service.NaverAuthService;
import com.example.dailyboramspring.domain.user.service.UpdateProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final NaverAuthService naverAuthService;
    private final GetUserProfileService getUserProfileService;
    private final GetMyUserProfileService getMyUserProfileService;
    private final UpdateProfileService updateProfileService;

    @GetMapping("/login/oauth2/code/naver")
    public TokenResponse get(String code) {
        return naverAuthService.execute(code);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/profile/other/{user_id}")
    public UserProfileResponse getUserProfile(@PathVariable(name = "user_id") Long id) {
        return getUserProfileService.execute(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/profile/me")
    public MyUserProfileResponse getUserProfile() {
        return getMyUserProfileService.execute();
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/profile")
    public void updateProfile(@RequestBody @Valid UpdateProfileRequest updateProfileRequest) {
        updateProfileService.execute(updateProfileRequest);
    }
}