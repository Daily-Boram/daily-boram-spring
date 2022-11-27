package com.example.dailyboramspring.domain.series.domain.repository;

import com.example.dailyboramspring.domain.genre.domain.Genre;
import com.example.dailyboramspring.domain.series.domain.Series;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.dailyboramspring.domain.genre.domain.QGenre.genre1;
import static com.example.dailyboramspring.domain.series.domain.QSeries.series;

@RequiredArgsConstructor
public class SeriesCustomImpl implements SeriesCustom {

    private final JPAQueryFactory query;

    private List<Series> queryRandom(String genre) {
        return
                query.selectFrom(series)
                        .leftJoin(series.genre, genre1)
                        .where(genre1.genre.eq(genre))
                        .orderBy(Expressions.numberTemplate(Double.class, "function('rand')").asc())
                        .fetch();
    }

    private List<Series> queryLike(String genre) {
        return
                query.selectFrom(series)
                        .leftJoin(series.genre, genre1)
                        .where(genre1.genre.eq(genre))
                        .orderBy(series.seriesLike.size().desc())
                        .fetch();
    }

    private List<Series> queryTime(String genre) {
        return
                query.selectFrom(series)
                        .leftJoin(series.genre, genre1)
                        .where(genre1.genre.eq(genre))
                        .orderBy(series.createdAt.desc())
                        .fetch();
    }

    @Override
    public List<Series> queryAll(String genre, String sort) {
        switch (sort) {
            case "like":
                return queryLike(genre);
            case "time":
                return queryTime(genre);
            default:
                return queryRandom(genre);
        }
    }

    @Override
    public List<Series> queryAll() {
        return query.selectFrom(series)
                .orderBy(series.seriesLike.size().desc())
                .limit(3)
                .fetch();
    }

    @Override
    public List<Series> queryAll(String sort) {
        switch (sort) {
            case "like":
                return query.selectFrom(series)
                        .orderBy(series.seriesLike.size().desc())
                        .fetch();
            case "time":
                return query.selectFrom(series)
                        .orderBy(series.createdAt.desc())
                        .fetch();
            default:
                return query.selectFrom(series)
                        .orderBy(Expressions.numberTemplate(Double.class, "function('rand')").asc())
                        .fetch();
        }
    }
}