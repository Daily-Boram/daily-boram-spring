package com.example.dailyboramspring.domain.content.service;

import com.example.dailyboramspring.domain.character.domain.Character;
import com.example.dailyboramspring.domain.character.facade.CharacterFacade;
import com.example.dailyboramspring.domain.content.domain.Content;
import com.example.dailyboramspring.domain.content.domain.repository.ContentRepository;
import com.example.dailyboramspring.domain.content.presentation.dto.request.CreateContentRequest;
import com.example.dailyboramspring.domain.episode.domain.Episode;
import com.example.dailyboramspring.domain.episode.facade.EpisodeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateContentService {

    private final ContentRepository contentRepository;
    private final EpisodeFacade episodeFacade;
    private final CharacterFacade characterFacade;

    @Transactional
    public void execute(Long episodeId, Long characterId, CreateContentRequest request) {
        Character character = characterFacade.findCharacterById(characterId);
        Episode episode = episodeFacade.getEpisodeById(episodeId);

        contentRepository.save(
                Content.builder()
                        .episode(episode)
                        .character(character)
                        .line(request.getLine())
                        .build()
        );
    }
}