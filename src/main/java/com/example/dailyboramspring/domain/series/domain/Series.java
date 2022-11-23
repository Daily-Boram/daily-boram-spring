package com.example.dailyboramspring.domain.series.domain;

import com.example.dailyboramspring.domain.genre.domain.Genre;
import com.example.dailyboramspring.domain.serieslike.domain.SeriesLike;
import com.example.dailyboramspring.domain.user.domain.User;
import com.example.dailyboramspring.global.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@Table(name = "tbl_series")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Series extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @Column(columnDefinition = "VARCHAR(25)")
    private String title;

    @NotNull
    @Column(columnDefinition = "VARCHAR(400)")
    private String summary;

    @NotNull
    @Column(columnDefinition = "VARCHAR(500)")
    private String image;

    @Builder
    public Series(User user, String title, String summary, String image) {
        this.user = user;
        this.title = title;
        this.summary = summary;
        this.image = image;
    }
}