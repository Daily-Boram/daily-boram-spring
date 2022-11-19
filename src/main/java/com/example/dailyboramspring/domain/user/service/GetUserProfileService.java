package com.example.dailyboramspring.domain.user.service;

import com.example.dailyboramspring.domain.user.presentation.dto.response.SeriesElement;
import com.example.dailyboramspring.domain.user.presentation.dto.response.UserProfileResponse;
import com.example.dailyboramspring.domain.series.facade.SeriesFacade;
import com.example.dailyboramspring.domain.serieslike.facade.SeriesLikeFacade;
import com.example.dailyboramspring.domain.user.domain.User;
import com.example.dailyboramspring.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetUserProfileService {

    private final UserFacade userFacade;
    private final SeriesFacade seriesFacade;
    private final SeriesLikeFacade seriesLikeFacade;


    public UserProfileResponse execute(Long id) {

        User user = userFacade.getUserById(id);

        List<SeriesElement> noticeList = seriesFacade.GetAllSeriesByUser(user)
                .stream()
                .map(series -> SeriesElement.builder()
                        .title(series.getTitle())
                        .nickname(user.getNickname())
                        .image(series.getImage())
                        .like(seriesLikeFacade.getCountBySeries(series))
                        .build())
                .collect(Collectors.toList());

        return new UserProfileResponse(
                user.getNickname(),
                user.getImage(),
                user.getIntroduce(),
                noticeList
        );
    }
}
