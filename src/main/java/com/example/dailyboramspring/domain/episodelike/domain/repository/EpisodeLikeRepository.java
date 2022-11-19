package com.example.dailyboramspring.domain.episodelike.domain.repository;

import com.example.dailyboramspring.domain.episode.domain.Episode;
import com.example.dailyboramspring.domain.episodelike.domain.EpisodeLike;
import com.example.dailyboramspring.domain.episodelike.domain.EpisodeLikeId;
import com.example.dailyboramspring.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EpisodeLikeRepository extends CrudRepository<EpisodeLike, EpisodeLikeId> {
    boolean existsEpisodeLikeByUserAndEpisode(User user, Episode episode);

    Optional<EpisodeLike> findEpisodeLikeByUserAndEpisode(User user, Episode episode);
}