package com.example.dailyboramspring.domain.genre.domain;

import com.example.dailyboramspring.domain.series.domain.Series;
import lombok.*;

import javax.persistence.*;

@Getter
@Table(name = "tbl_genre")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_id", nullable = false)
    private Series series;

    @Column(columnDefinition = "VARCHAR(5)")
    private String genre;
}