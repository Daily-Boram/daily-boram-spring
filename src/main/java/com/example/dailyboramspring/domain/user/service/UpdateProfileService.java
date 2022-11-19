package com.example.dailyboramspring.domain.user.service;

import com.example.dailyboramspring.domain.user.exception.NicknameOverlapException;
import com.example.dailyboramspring.domain.user.presentation.dto.request.UpdateProfileRequest;
import com.example.dailyboramspring.domain.user.domain.User;
import com.example.dailyboramspring.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateProfileService {

    private final UserFacade userFacade;

    @Transactional
    public void execute(UpdateProfileRequest updateProfileRequest) {
        User user = userFacade.getCurrentUser();

        if (userFacade.existByNickname(updateProfileRequest.getNickname())) {
            throw NicknameOverlapException.EXCEPTION;
        }

        user.changeProfile(updateProfileRequest.getNickname(), updateProfileRequest.getImage(), updateProfileRequest.getIntroduce());
    }
}
