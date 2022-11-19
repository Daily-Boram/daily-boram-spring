package com.example.dailyboramspring.domain.episodelike.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class EpisodeLikeId implements Serializable {

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long episodeId;
}