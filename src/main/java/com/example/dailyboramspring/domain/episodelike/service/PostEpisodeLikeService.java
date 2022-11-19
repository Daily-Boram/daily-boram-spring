package com.example.dailyboramspring.domain.episodelike.service;

import com.example.dailyboramspring.domain.episode.facade.EpisodeFacade;
import com.example.dailyboramspring.domain.episodelike.domain.EpisodeLike;
import com.example.dailyboramspring.domain.episodelike.domain.EpisodeLikeId;
import com.example.dailyboramspring.domain.episodelike.domain.repository.EpisodeLikeRepository;
import com.example.dailyboramspring.domain.user.domain.User;
import com.example.dailyboramspring.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostEpisodeLikeService {

    private final EpisodeLikeRepository episodeLikeRepository;
    private final EpisodeFacade episodeFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long episodeId) {

        User user = userFacade.getCurrentUser();

        episodeLikeRepository.save(
                EpisodeLike.builder()
                        .id(new EpisodeLikeId(user.getId(), episodeId))
                        .user(user)
                        .episode(episodeFacade.getEpisodeById(episodeId))
                        .build()
        );
    }
}
