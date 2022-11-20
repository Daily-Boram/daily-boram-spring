package com.example.dailyboramspring.domain.genre.domain.repository;

import com.example.dailyboramspring.domain.genre.domain.Genre;
import com.example.dailyboramspring.domain.series.domain.Series;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    List<Genre> findAllBySeries(Series series);

   Optional<Genre> findByGenre(String genre);
}