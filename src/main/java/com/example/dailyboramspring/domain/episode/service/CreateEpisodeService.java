package com.example.dailyboramspring.domain.episode.service;

import com.example.dailyboramspring.domain.character.domain.Character;
import com.example.dailyboramspring.domain.character.domain.repository.CharacterRepository;
import com.example.dailyboramspring.domain.character.exception.CharacterExistsException;
import com.example.dailyboramspring.domain.character.facade.CharacterFacade;
import com.example.dailyboramspring.domain.content.domain.Content;
import com.example.dailyboramspring.domain.content.domain.repository.ContentRepository;
import com.example.dailyboramspring.domain.episode.domain.Episode;
import com.example.dailyboramspring.domain.episode.domain.repository.EpisodeRepository;
import com.example.dailyboramspring.domain.episode.presentation.dto.request.CreateEpisodeRequest;
import com.example.dailyboramspring.domain.series.domain.Series;
import com.example.dailyboramspring.domain.series.facade.SeriesFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreateEpisodeService {

    private final EpisodeRepository episodeRepository;
    private final CharacterRepository characterRepository;
    private final ContentRepository contentRepository;
    private final CharacterFacade characterFacade;
    private final SeriesFacade seriesFacade;

    @Transactional
    public void execute(Long seriesId, CreateEpisodeRequest request) {
        Series series = seriesFacade.findById(seriesId);

        Episode episode = episodeRepository.save(
                Episode.builder()
                        .title(request.getTitle())
                        .cost(request.getCost())
                        .image(request.getImage())
                        .series(series)
                        .build()
        );


        for(CreateEpisodeRequest.Character_list character_list : request.getCharacter()) {
            log.info(character_list.getImage());
            log.info(character_list.getName());
            if (characterRepository.findByNameAndSeries(character_list.getName(), series).isEmpty()) {
                characterRepository.save(
                        Character.builder()
                                .image(character_list.getImage())
                                .name(character_list.getName())
                                .series(series)
                                .build()
                );
            }
        }

        for(CreateEpisodeRequest.Content_list content_list : request.getContent()) {
            Character character = characterFacade.findCharacterByNameAndSeries(content_list.getName(), series);

            contentRepository.save(
                    Content.builder()
                            .character(character)
                            .episode(episode)
                            .line(content_list.getLine())
                            .build()
            );
        }
    }
}