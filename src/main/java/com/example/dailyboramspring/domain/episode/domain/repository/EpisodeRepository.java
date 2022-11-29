package com.example.dailyboramspring.domain.episode.domain.repository;

import com.example.dailyboramspring.domain.episode.domain.Episode;
import com.example.dailyboramspring.domain.series.domain.Series;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface EpisodeRepository extends CrudRepository<Episode, Long>, EpisodeCustom {


    List<Episode> findAllBySeries(Series series);

    List<Episode> findEpisodesBySeriesOrderByIdAsc(Series series, Pageable pageable);

    Boolean existsEpisodeById(Long id);

}
