package com.example.dailyboramspring.domain.series.domain.repository;

import com.example.dailyboramspring.domain.series.domain.Series;
import com.example.dailyboramspring.domain.user.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import java.util.Optional;

public interface SeriesRepository extends CrudRepository<Series, Long> {
    Optional<Series> findById(Long seriesId);

    List<Series> findAllByUser(User user);

    List<Series> findAllByTitleContaining(String title);
}