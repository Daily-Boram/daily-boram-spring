package com.example.dailyboramspring.domain.series.domain.repository;

import com.example.dailyboramspring.domain.genre.domain.Genre;
import com.example.dailyboramspring.domain.series.domain.Series;

import java.util.List;

public interface SeriesCustom {
    List<Series> queryAll(String genre, String sort);

    List<Series> queryAll();
}