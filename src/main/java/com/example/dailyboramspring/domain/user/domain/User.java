package com.example.dailyboramspring.domain.user.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "tbl_user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(columnDefinition = "VARCHAR(100)")
    private String email;

    @NotNull
    @Column(columnDefinition = "CHAR(1)")
    private String gender;

    @NotNull
    @Column(columnDefinition = "VARCHAR(5)")
    private String age;

    @NotNull
    @Column(columnDefinition = "CHAR(13)")
    private String phoneNumber;

    @NotNull
    @Column(columnDefinition = "VARCHAR(30)", unique = true)
    private String nickname;

    @Column(columnDefinition = "VARCHAR(100)")
    private String introduce;

    @NotNull
    @Column(columnDefinition = "VARCHAR(2500)")
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