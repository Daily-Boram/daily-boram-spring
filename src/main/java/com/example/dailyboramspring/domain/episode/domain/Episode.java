package com.example.dailyboramspring.domain.episode.domain;

import com.example.dailyboramspring.domain.series.domain.Series;
import com.example.dailyboramspring.global.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "tbl_episode")
@Entity
public class Episode extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_id", nullable = false)
    private Series series;

    @NotNull
    @Column(columnDefinition = "VARCHAR(30)")
    private String title;

    @NotNull
    @Column(columnDefinition = "INT")
    private Integer cost;

    @NotNull
    @Column(columnDefinition = "VARCHAR(500)")
    private String image;

}
