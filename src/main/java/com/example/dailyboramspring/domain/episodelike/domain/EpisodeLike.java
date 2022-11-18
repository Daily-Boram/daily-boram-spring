package com.example.dailyboramspring.domain.episodelike.domain;

import com.example.dailyboramspring.domain.episode.domain.Episode;
import com.example.dailyboramspring.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "tbl_episode_like",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "episode_id"})
)
@Entity
public class EpisodeLike {

    @EmbeddedId
    private EpisodeLikeId id;

    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @MapsId("episodeId")
    @JoinColumn(name = "episode_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Episode episode;
}