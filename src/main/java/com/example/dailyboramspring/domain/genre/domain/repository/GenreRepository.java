package com.example.dailyboramspring.domain.genre.domain.repository;

import com.example.dailyboramspring.domain.genre.domain.Genre;
import com.example.dailyboramspring.domain.series.domain.Series;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Series>{
}
