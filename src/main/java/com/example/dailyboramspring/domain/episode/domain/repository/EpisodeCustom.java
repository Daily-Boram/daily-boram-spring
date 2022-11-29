package com.example.dailyboramspring.domain.episode.domain.repository;

import com.example.dailyboramspring.domain.episode.domain.Episode;
import com.example.dailyboramspring.domain.series.domain.Series;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EpisodeCustom {
    List<Episode> queryAllEpisodePaging(Series series, Pageable pageable);
}
