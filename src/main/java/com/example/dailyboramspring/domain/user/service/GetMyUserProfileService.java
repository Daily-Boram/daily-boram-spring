package com.example.dailyboramspring.domain.profile.service;

import com.example.dailyboramspring.domain.profile.facade.ProfileFacade;
import com.example.dailyboramspring.domain.profile.presentation.dto.response.MyUserProfileResponse;
import com.example.dailyboramspring.domain.profile.presentation.dto.response.PurchaseElement;
import com.example.dailyboramspring.domain.profile.presentation.dto.response.SeriesElement;
import com.example.dailyboramspring.domain.purchase.facade.PurchaseFacade;
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
public class GetMyUserProfileService {

    private final UserFacade userFacade;
    private final ProfileFacade profileFacade;
    private final SeriesFacade seriesFacade;
    private final SeriesLikeFacade seriesLikeFacade;
    private final PurchaseFacade purchaseFacade;


    public MyUserProfileResponse execute() {

        User user = userFacade.getCurrentUser();

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

        List<PurchaseElement> purchaseList = purchaseFacade.GetAllByUser(user)
                .stream()
                .map(purchase -> PurchaseElement.builder()
                        .seriesTitle(purchase.getEpisode().getSeries().getTitle())
                        .episodeTitle(purchase.getEpisode().getTitle())
                        .cost(purchase.getEpisode().getCost())
                        .build())
                .collect(Collectors.toList());

        return new MyUserProfileResponse(
                profile.getNickname(),
                profile.getImage(),
                profile.getIntroduce(),
                noticeList,
                purchaseList
        );
    }
}
