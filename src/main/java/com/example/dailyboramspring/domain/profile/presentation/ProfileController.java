package com.example.dailyboramspring.domain.profile.presentation;

import com.example.dailyboramspring.domain.profile.presentation.dto.response.MyUserProfileResponse;
import com.example.dailyboramspring.domain.profile.presentation.dto.response.UserProfileResponse;
import com.example.dailyboramspring.domain.profile.service.GetMyUserProfileService;
import com.example.dailyboramspring.domain.profile.service.GetUserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/profile")
@RestController
public class ProfileController {

    private final GetUserProfileService getUserProfileService;
    private final GetMyUserProfileService getMyUserProfileService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/ohter/{user_id}")
    public UserProfileResponse getUserProfile(@PathVariable(name = "user_id") Long id) {
        return getUserProfileService.execute(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/me")
    public MyUserProfileResponse getUserProfile() {
        return getMyUserProfileService.execute();
    }
}
