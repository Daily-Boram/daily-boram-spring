package com.example.dailyboramspring.domain.profile.facade;

import com.example.dailyboramspring.domain.profile.domain.Profile;
import com.example.dailyboramspring.domain.profile.domain.repository.ProfileRepository;
import com.example.dailyboramspring.domain.profile.exception.UserNotFoundException;
import com.example.dailyboramspring.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProfileFacade {

    private final ProfileRepository profileRepository;

    public Profile getProfileById(long id) {
        return profileRepository.findById(id).orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
