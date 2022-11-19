package com.example.dailyboramspring.domain.episode.service;

import com.example.dailyboramspring.domain.content.facade.ContentFacade;
import com.example.dailyboramspring.domain.episode.domain.Episode;
import com.example.dailyboramspring.domain.episode.facade.EpisodeFacade;
import com.example.dailyboramspring.domain.episode.presentation.dto.response.ContentList;
import com.example.dailyboramspring.domain.episode.presentation.dto.response.GetEpisodeResponse;
import com.example.dailyboramspring.domain.episodelike.facade.EpisodeLikeFacade;
import com.example.dailyboramspring.domain.user.domain.User;
import com.example.dailyboramspring.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetEpisodeService {

    private final EpisodeFacade episodeFacade;
    private final EpisodeLikeFacade episodeLikeFacade;
    private final UserFacade userFacade;
    private final ContentFacade contentFacade;

    public GetEpisodeResponse getEpisode(Long episodeId) {
        Episode episode = episodeFacade.getEpisodeById(episodeId);
        User user = userFacade.getCurrentUser();

        List<ContentList> contentLists = contentFacade.getContentsByEpisode(episode)
                .stream()
                .map(content -> ContentList.builder()
                        .id(content.getId())
                        .image(content.getCharacter().getImage())
                        .name(content.getCharacter().getName())
                        .line(content.getLine())
                        .build()
                )
                .collect(Collectors.toList());

        return GetEpisodeResponse.builder()
                .image(episode.getImage())
                .title(episode.getTitle())
                .episodeNumber(episode.getId())
                .isLike(episodeLikeFacade.existsEpisodeLike(user, episode))
                .contentList(contentLists)
                .build();
    }
}