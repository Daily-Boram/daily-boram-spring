package com.example.dailyboramspring.domain.episode.domain.repository;

import com.example.dailyboramspring.domain.episode.domain.Episode;
import com.example.dailyboramspring.domain.series.domain.Series;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.example.dailyboramspring.domain.series.domain.QSeries.series;
import static com.example.dailyboramspring.domain.episode.domain.QEpisode.episode;

@RequiredArgsConstructor
public class EpisodeCustomImpl implements EpisodeCustom {

    private final JPAQueryFactory query;

    @Override
    public List<Episode> queryAllEpisodePaging(Series series1, Pageable pageable) {
        return query.selectFrom(episode)
                .leftJoin(episode.series, series)
                .where(series.eq(series1))
                .orderBy(series.id.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }
}

// 1 10
// 2 20
// 3 30