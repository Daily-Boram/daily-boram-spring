package com.example.dailyboramspring.domain.character.domain.repository;

import com.example.dailyboramspring.domain.character.domain.Character;
import org.springframework.data.repository.CrudRepository;

public interface CharacterRepository extends CrudRepository<Character, Long> {
}
