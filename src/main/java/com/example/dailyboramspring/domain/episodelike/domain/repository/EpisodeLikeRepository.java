package com.example.dailyboramspring.domain.episodelike.domain.repository;

import com.example.dailyboramspring.domain.episodelike.domain.EpisodeLike;
import com.example.dailyboramspring.domain.episodelike.domain.EpisodeLikeId;
import org.springframework.data.repository.CrudRepository;

public interface EpisodeLikeRepository extends CrudRepository<EpisodeLike, EpisodeLikeId> {
}