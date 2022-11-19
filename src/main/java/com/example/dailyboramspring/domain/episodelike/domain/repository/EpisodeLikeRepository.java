package com.example.dailyboramspring.domain.episodelike.domain.repository;

import com.example.dailyboramspring.domain.episode.domain.Episode;
import com.example.dailyboramspring.domain.episodelike.domain.EpisodeLike;
import com.example.dailyboramspring.domain.episodelike.domain.EpisodeLikeId;
import com.example.dailyboramspring.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface EpisodeLikeRepository extends CrudRepository<EpisodeLike, EpisodeLikeId> {
    boolean existsEpisodeLikeByUserAndEpisode(User user, Episode episode);
}