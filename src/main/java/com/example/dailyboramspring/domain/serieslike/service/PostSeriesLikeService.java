package com.example.dailyboramspring.domain.serieslike.service;

import com.example.dailyboramspring.domain.series.facade.SeriesFacade;
import com.example.dailyboramspring.domain.serieslike.domain.SeriesLike;
import com.example.dailyboramspring.domain.serieslike.domain.SeriesLikeId;
import com.example.dailyboramspring.domain.serieslike.domain.repository.SeriesLikeRepository;
import com.example.dailyboramspring.domain.user.domain.User;
import com.example.dailyboramspring.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostSeriesLikeService {

    private final UserFacade userFacade;
    private final SeriesLikeRepository seriesLikeRepository;
    private final SeriesFacade seriesFacade;

    @Transactional
    public void execute(Long seriesId) {

        User user = userFacade.getCurrentUser();

        seriesLikeRepository.save(
                SeriesLike.builder()
                        .id(new SeriesLikeId(user.getId(), seriesFacade.findById(seriesId).getId()))
                        .user(user)
                        .series(seriesFacade.findById(seriesId))
                        .build()
        );
    }
}
