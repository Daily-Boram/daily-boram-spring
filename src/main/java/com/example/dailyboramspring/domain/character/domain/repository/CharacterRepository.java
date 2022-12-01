package com.example.dailyboramspring.domain.character.domain.repository;

import com.example.dailyboramspring.domain.character.domain.Character;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CharacterRepository extends CrudRepository<Character, Long> {
    Optional<Character> findByNameAndImage(String name, String image);
}
