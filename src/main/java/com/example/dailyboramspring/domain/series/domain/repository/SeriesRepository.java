package com.example.dailyboramspring.domain.series.domain.repository;

import com.example.dailyboramspring.domain.genre.domain.Genre;
import com.example.dailyboramspring.domain.series.domain.Series;
import com.example.dailyboramspring.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SeriesRepository extends JpaRepository<Series, Long>, SeriesCustom {
    Optional<Series> findById(Long seriesId);

    List<Series> findAllByUser(User user);

    List<Series> findAllByTitleContaining(String title);
}