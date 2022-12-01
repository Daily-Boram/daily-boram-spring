package com.example.dailyboramspring.domain.character.facade;

import com.example.dailyboramspring.domain.character.domain.Character;
import com.example.dailyboramspring.domain.character.domain.repository.CharacterRepository;
import com.example.dailyboramspring.domain.character.exception.CharacterNotFoundException;
import com.example.dailyboramspring.domain.series.domain.Series;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CharacterFacade {

    private final CharacterRepository characterRepository;

    public Character findCharacterById(Long characterId) {
        return characterRepository.findById(characterId)
                .orElseThrow(() -> CharacterNotFoundException.EXCEPTION);
    }

    public Character findCharacterByNameAndImageAndSeries(String name, Series series, String image) {
        return characterRepository.findByNameAndSeriesAndImage(name, series, image)
                .orElseThrow(() -> CharacterNotFoundException.EXCEPTION);
    }
}