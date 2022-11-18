package com.example.dailyboramspring.domain.profile.domain.repository;

import com.example.dailyboramspring.domain.profile.domain.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
    Boolean existsByNickname(String nickname);
}
