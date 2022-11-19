package com.example.dailyboramspring.domain.episodelike.service;

import com.example.dailyboramspring.domain.episode.facade.EpisodeFacade;
import com.example.dailyboramspring.domain.episodelike.domain.repository.EpisodeLikeRepository;
import com.example.dailyboramspring.domain.episodelike.facade.EpisodeLikeFacade;
import com.example.dailyboramspring.domain.user.domain.User;
import com.example.dailyboramspring.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteEpisodeLikeService {

    private final EpisodeLikeRepository episodeLikeRepository;
    private final EpisodeLikeFacade episodeLikeFacade;
    private final EpisodeFacade episodeFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(long episodeId) {

        User user = userFacade.getCurrentUser();

        episodeLikeRepository.delete(episodeLikeFacade.getEpisodeLike(user, episodeFacade.getEpisodeById(episodeId)));
    }
}
