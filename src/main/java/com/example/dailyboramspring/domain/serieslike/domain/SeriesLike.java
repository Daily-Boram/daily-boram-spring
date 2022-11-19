package com.example.dailyboramspring.domain.serieslike.domain;

import com.example.dailyboramspring.domain.series.domain.Series;
import com.example.dailyboramspring.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "tbl_series_like",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "series_id"})
)
@Entity
public class SeriesLike {

    @EmbeddedId
    private SeriesLikeId id;
    
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @MapsId("seriesId")
    @JoinColumn(name = "series_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Series series;
}