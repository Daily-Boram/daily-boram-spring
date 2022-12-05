package com.example.dailyboramspring.domain.character.domain.repository;

import com.example.dailyboramspring.domain.character.domain.Character;
import com.example.dailyboramspring.domain.series.domain.Series;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository extends CrudRepository<Character, Long> {
    Optional<Character> findByNameAndSeries(String name, Series series);

    List<Character> deleteAllBySeries(Series series);
}
