package com.example.dailyboramspring.domain.profile.presentation;

import com.example.dailyboramspring.domain.profile.presentation.dto.response.UserProfileResponse;
import com.example.dailyboramspring.domain.profile.service.GetUserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/profile")
@RestController
public class ProfileController {

    private final GetUserProfileService getUserProfileService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{user_id}")
    public UserProfileResponse getUserProfile(@PathVariable(name = "user_id") Long id) {
        return getUserProfileService.excute(id);
    }
}
