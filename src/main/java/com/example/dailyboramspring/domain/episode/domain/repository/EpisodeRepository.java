package com.example.dailyboramspring.domain.episode.domain.repository;

import com.example.dailyboramspring.domain.episode.domain.Episode;
import org.springframework.data.repository.CrudRepository;

public interface EpisodeRepository extends CrudRepository<Episode, Long> {
}
