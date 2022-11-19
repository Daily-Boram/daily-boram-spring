package com.example.dailyboramspring.domain.serieslike.service;

import com.example.dailyboramspring.domain.series.facade.SeriesFacade;
import com.example.dailyboramspring.domain.serieslike.domain.repository.SeriesLikeRepository;
import com.example.dailyboramspring.domain.serieslike.facade.SeriesLikeFacade;
import com.example.dailyboramspring.domain.user.domain.User;
import com.example.dailyboramspring.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteSeriesLikeService {

    private final UserFacade userFacade;
    private final SeriesLikeFacade seriesLikeFacade;
    private final SeriesLikeRepository seriesLikeRepository;
    private final SeriesFacade seriesFacade;

    public void execute(Long seriesId) {

        User user = userFacade.getCurrentUser();

        seriesLikeRepository.delete(seriesLikeFacade.getSeriesLike(user, seriesFacade.findById(seriesId)));
    }
}
