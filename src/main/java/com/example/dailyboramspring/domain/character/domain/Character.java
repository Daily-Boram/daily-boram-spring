package com.example.dailyboramspring.domain.character.domain;

import com.example.dailyboramspring.domain.series.domain.Series;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_character",
        uniqueConstraints = @UniqueConstraint(columnNames = {"name","series_id"})
)
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
    @Size(max = 2400)
    @Column(columnDefinition = "VARCHAR(2400)")
    private String image;

}
