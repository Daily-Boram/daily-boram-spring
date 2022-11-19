package com.example.dailyboramspring.domain.series.service;

import com.example.dailyboramspring.domain.genre.domain.Genre;
import com.example.dailyboramspring.domain.genre.domain.repository.GenreRepository;
import com.example.dailyboramspring.domain.series.domain.Series;
import com.example.dailyboramspring.domain.series.domain.repository.SeriesRepository;
import com.example.dailyboramspring.domain.series.presentation.dto.requset.CreateSeriesRequest;
import com.example.dailyboramspring.domain.user.domain.User;
import com.example.dailyboramspring.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateSeries {

    private final SeriesRepository seriesRepository;
    private final UserFacade userFacade;
    private final GenreRepository genreRepository;

    @Transactional
    public void execute(CreateSeriesRequest createSeriesRequest) {
        User user = userFacade.getCurrentUser();

        Series series = seriesRepository.save(
                Series.builder()
                        .title(createSeriesRequest.getTitle())
                        .summary(createSeriesRequest.getSummary())
                        .image(createSeriesRequest.getImage())
                        .user(user)
                        .build()
        );

        for (String i : createSeriesRequest.getGenre()) {
            genreRepository.save(
                    Genre.builder()
                            .series(series)
                            .genre(i)
                            .build()
            );
        }
    }
}