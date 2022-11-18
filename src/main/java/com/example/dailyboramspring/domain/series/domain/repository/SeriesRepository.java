package com.example.dailyboramspring.domain.series.domain.repository;

import com.example.dailyboramspring.domain.series.domain.Series;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SeriesRepository extends CrudRepository<Series, Long> {
    Optional<Series> findById(Long seriesId);
}