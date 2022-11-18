package com.example.dailyboramspring.domain.profile.domain;

import com.example.dailyboramspring.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tbl_profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
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

    @Builder
    public Profile(User user, String title, String summary, String image) {
        this.user = user;
        this.title = title;
        this.summary = summary;
        this.image = image;
    }
}
