package com.example.dailyboramspring.domain.serieslike.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@Embeddable
public class SeriesLikeId implements Serializable {
    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long seriesId;
}