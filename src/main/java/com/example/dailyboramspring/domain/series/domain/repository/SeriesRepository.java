package com.example.dailyboramspring.domain.series.domain.repository;

import com.example.dailyboramspring.domain.series.domain.Series;
import com.example.dailyboramspring.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeriesRepository extends CrudRepository<Series, Long> {

    public List<Series> findAllByUser(User user);
}
