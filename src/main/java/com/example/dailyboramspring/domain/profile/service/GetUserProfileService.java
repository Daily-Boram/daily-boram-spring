package com.example.dailyboramspring.domain.profile.service;

import com.example.dailyboramspring.domain.profile.domain.Profile;
import com.example.dailyboramspring.domain.profile.facade.ProfileFacade;
import com.example.dailyboramspring.domain.profile.presentation.dto.response.SeriesElement;
import com.example.dailyboramspring.domain.profile.presentation.dto.response.UserProfileResponse;
import com.example.dailyboramspring.domain.series.domain.Series;
import com.example.dailyboramspring.domain.series.facade.SeriesFacade;
import com.example.dailyboramspring.domain.serieslike.domain.SeriesLikeId;
import com.example.dailyboramspring.domain.serieslike.facade.SeriesLikeFacade;
import com.example.dailyboramspring.domain.user.domain.User;
import com.example.dailyboramspring.domain.user.domain.repository.UserRepository;
import com.example.dailyboramspring.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetUserProfileService {

    private final UserFacade userFacade;
    private final ProfileFacade profileFacade;
    private final SeriesFacade seriesFacade;
    private final SeriesLikeFacade seriesLikeFacade;


    public UserProfileResponse execute(Long id) {

        User user = userFacade.getUserById(id);

        Profile profile = profileFacade.getProfileById(user.getId());

        List<SeriesElement> noticeList = seriesFacade.GetAllSeriesByUser(user)
                .stream()
                .map(series -> SeriesElement.builder()
                        .title(series.getTitle())
                        .nickname(profile.getNickname())
                        .image(series.getImage())
                        .like(seriesLikeFacade.getCountBySeries(series))
                        .build())
                .collect(Collectors.toList());

        return new UserProfileResponse(
                profile.getNickname(),
                profile.getImage(),
                profile.getIntroduce(),
                noticeList
        );
    }
}
