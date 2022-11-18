package com.example.dailyboramspring.domain.profile.service;

import com.example.dailyboramspring.domain.profile.domain.Profile;
import com.example.dailyboramspring.domain.profile.exception.NicknameOverlapException;
import com.example.dailyboramspring.domain.profile.facade.ProfileFacade;
import com.example.dailyboramspring.domain.profile.presentation.dto.request.UpdateProfileRequest;
import com.example.dailyboramspring.domain.user.domain.User;
import com.example.dailyboramspring.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateProfileService {

    private final UserFacade userFacade;
    private final ProfileFacade profileFacade;

    @Transactional
    public void execute(UpdateProfileRequest updateProfileRequest) {
        User user = userFacade.getCurrentUser();

        if (profileFacade.existByNickname(updateProfileRequest.getNickname())) {
            throw NicknameOverlapException.EXCEPTION;
        }

        Profile profile = profileFacade.getProfileById(user.getId());

        profile.changeProfile(updateProfileRequest.getNickname(), updateProfileRequest.getImage(), updateProfileRequest.getIntroduce());
    }
}
