package com.example.dailyboramspring.domain.episodelike.facade;

import com.example.dailyboramspring.domain.episode.domain.Episode;
import com.example.dailyboramspring.domain.episodelike.domain.EpisodeLike;
import com.example.dailyboramspring.domain.episodelike.domain.repository.EpisodeLikeRepository;
import com.example.dailyboramspring.domain.episodelike.exception.EpisodeLikeNotFoundException;
import com.example.dailyboramspring.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EpisodeLikeFacade {

    private final EpisodeLikeRepository episodeLikeRepository;

    public boolean existsEpisodeLike(User user, Episode episode) {
        return episodeLikeRepository.existsEpisodeLikeByUserAndEpisode(user, episode);
    }

    public EpisodeLike getEpisodeLike(User user, Episode episode) {
        return episodeLikeRepository.findEpisodeLikeByUserAndEpisode(user, episode)
                .orElseThrow(() -> EpisodeLikeNotFoundException.EXCEPTION);
    }
}