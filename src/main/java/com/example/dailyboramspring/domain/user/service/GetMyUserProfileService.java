package com.example.dailyboramspring.domain.user.service;

import com.example.dailyboramspring.domain.purchase.facade.PurchaseFacade;
import com.example.dailyboramspring.domain.series.facade.SeriesFacade;
import com.example.dailyboramspring.domain.serieslike.facade.SeriesLikeFacade;
import com.example.dailyboramspring.domain.user.domain.User;
import com.example.dailyboramspring.domain.user.facade.UserFacade;
import com.example.dailyboramspring.domain.user.presentation.dto.response.MyUserProfileResponse;
import com.example.dailyboramspring.domain.user.presentation.dto.response.PurchaseElement;
import com.example.dailyboramspring.domain.user.presentation.dto.response.SeriesElement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class GetMyUserProfileService {

    private final UserFacade userFacade;
    private final SeriesFacade seriesFacade;
    private final SeriesLikeFacade seriesLikeFacade;
    private final PurchaseFacade purchaseFacade;

    @Transactional(readOnly = true)
    public MyUserProfileResponse execute() {

        User user = userFacade.getCurrentUser();

        List<SeriesElement> noticeList = seriesFacade.GetAllSeriesByUser(user)
                .stream()
                .map(series -> SeriesElement.builder()
                        .title(series.getTitle())
                        .nickname(user.getNickname())
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
                user.getNickname(),
                user.getImage(),
                user.getIntroduce(),
                noticeList,
                purchaseList
        );
    }
}