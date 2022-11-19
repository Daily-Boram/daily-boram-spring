package com.example.dailyboramspring.domain.character.service;

import com.example.dailyboramspring.domain.character.domain.Character;
import com.example.dailyboramspring.domain.character.domain.repository.CharacterRepository;
import com.example.dailyboramspring.domain.character.presentation.dto.request.CreateCharacterRequest;
import com.example.dailyboramspring.domain.series.domain.Series;
import com.example.dailyboramspring.domain.series.facade.SeriesFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateCharacterService {

    private final CharacterRepository characterRepository;
    private final SeriesFacade seriesFacade;

    @Transactional
    public void execute(Long seriesId, CreateCharacterRequest request) {
        Series series = seriesFacade.findById(seriesId);

        characterRepository.save(
                Character.builder()
                        .series(series)
                        .image(request.getImage())
                        .name(request.getName())
                        .build()
        );
    }
}