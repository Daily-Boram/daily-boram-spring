package com.example.dailyboramspring.domain.profile.domain;

import com.example.dailyboramspring.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_profile")
public class Profile {

    @Id
    private Long Id;

    @MapsId
    @JoinColumn(name = "user_id", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @NotNull
    @Column(columnDefinition = "VARCHAR(30)")
    private String nickname;

    @Column(columnDefinition = "VARCHAR(100)")
    private String introduce;

    @NotNull
    @Column(columnDefinition = "VARCHAR(500)")
    private String image;

    @NotNull
    @Column(columnDefinition = "INT")
    private Integer cookie;

    public void changeProfile(String nickname, String image, String introduce) {
        this.nickname = nickname;
        this.image = image;
        this.introduce = introduce;
    }
}
