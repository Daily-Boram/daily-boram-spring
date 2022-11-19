package com.example.dailyboramspring.domain.content.domain.repository;

import com.example.dailyboramspring.domain.content.domain.Content;
import com.example.dailyboramspring.domain.episode.domain.Episode;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContentRepository extends CrudRepository<Content, Long> {
    List<Content> findAllByEpisode(Episode episode);
}