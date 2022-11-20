package com.example.dailyboramspring.domain.serieslike.domain.repository;

import com.example.dailyboramspring.domain.episode.domain.Episode;
import com.example.dailyboramspring.domain.series.domain.Series;
import com.example.dailyboramspring.domain.serieslike.domain.SeriesLike;
import com.example.dailyboramspring.domain.serieslike.domain.SeriesLikeId;
import com.example.dailyboramspring.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SeriesLikeRepository extends CrudRepository<SeriesLike, SeriesLikeId> {

    Integer countSeriesLikesBySeries(Series series);

    Optional<SeriesLike> findSeriesLikeByUserAndSeries(User user, Series series);
}