package com.example.dailyboramspring.domain.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(columnDefinition = "VARCHAR(30)")
    private String accountId;

    @NotNull
    @Column(columnDefinition = "CHAR(1)")
    private String gender;

    @NotNull
    @Column(columnDefinition = "VARCHAR(5)")
    private String age;

    @NotNull
    @Column(columnDefinition = "CHAR(20)")
    private String phoneNumber;

    @Builder
    public User(String accountId, String gender, String age, String phoneNumber) {
        this.accountId = accountId;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }
}
