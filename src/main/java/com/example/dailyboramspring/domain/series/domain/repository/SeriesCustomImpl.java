package com.example.dailyboramspring.domain.series.domain.repository;

import com.example.dailyboramspring.domain.series.domain.Series;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.dailyboramspring.domain.genre.domain.QGenre.genre1;
import static com.example.dailyboramspring.domain.series.domain.QSeries.series;
import static com.example.dailyboramspring.domain.serieslike.domain.QSeriesLike.seriesLike;

@RequiredArgsConstructor
public class SeriesCustomImpl implements SeriesCustom {

    private final JPAQueryFactory query;

    private List<Series> querySortSeries(String genre, String sort) {

        switch (sort) {
            case "random":
                query.selectFrom(series)
                        .join(series, genre1.series)
                        .where(
                                genre1.genre.eq(genre)
                        )
                        .fetch();
            case "like":
                return query.selectFrom(series)
                        .join(series, genre1.series)
                        .where(
                                genre1.genre.eq(genre)
                        )
                        .orderBy(series.modifiedAt.desc())
                        .fetch();
            default:
                return query.selectFrom(series)
                        .join(series, genre1.series)
                        .where(
                                genre1.genre.eq(genre)
                        )
                        .orderBy(series.createdAt.desc())
                        .fetch();
        }
    }

    @Override
    public List<Series> queryAll(String genre, String sort) {
        return querySortSeries(genre, sort);
    }

    @Override
    public List<Series> queryAll() {
        return query.selectFrom(series)
                .join(series, seriesLike.series)
                .orderBy(series.modifiedAt.desc())
                .fetch();
    }
}