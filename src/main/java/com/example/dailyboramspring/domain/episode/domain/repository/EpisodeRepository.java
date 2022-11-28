package com.example.dailyboramspring.domain.episode.domain.repository;

import com.example.dailyboramspring.domain.episode.domain.Episode;
import com.example.dailyboramspring.domain.series.domain.Series;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface EpisodeRepository extends CrudRepository<Episode, Long> {


    List<Episode> findAllBySeries(Series series);

    List<Episode> findAllBySeriesOrderByIdAsc(Series series, Pageable pageable);

    Boolean existsEpisodeById(Long id);

}
