package com.example.dailyboramspring.domain.character.domain;

import com.example.dailyboramspring.domain.series.domain.Series;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_character")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_id", nullable = false)
    private Series series;

    @NotNull
    @Column(columnDefinition = "VARCHAR(20)")
    private String name;

    @NotNull
    @Column(columnDefinition = "VARCAHR(500)")
    private String image;

}