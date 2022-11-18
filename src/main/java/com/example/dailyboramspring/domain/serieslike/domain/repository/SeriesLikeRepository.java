package com.example.dailyboramspring.domain.serieslike.domain.repository;

import com.example.dailyboramspring.domain.series.domain.Series;
import com.example.dailyboramspring.domain.serieslike.domain.SeriesLike;
import com.example.dailyboramspring.domain.serieslike.domain.SeriesLikeId;
import org.springframework.data.repository.CrudRepository;

public interface SeriesLikeRepository extends CrudRepository<SeriesLike, SeriesLikeId> {

    public Long countSeriesLikesBySeries(Series series);
}