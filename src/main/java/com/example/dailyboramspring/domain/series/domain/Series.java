package com.example.dailyboramspring.domain.series.domain;

import com.example.dailyboramspring.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Table(name = "tbl_series")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
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

    public Series(User user, String title, String summary, String image){
        this.user = user;
        this.title = title;
        this.summary = summary;
        this.image = image;
    }
}
