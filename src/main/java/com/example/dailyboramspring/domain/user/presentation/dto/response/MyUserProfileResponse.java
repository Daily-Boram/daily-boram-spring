package com.example.dailyboramspring.domain.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class MyUserProfileResponse {

    private String nickname;

    private String image;

    private String introduce;

    private Integer cookie;

    private List<SeriesElement> noticeList;

    private List<PurchaseElement> purchaseList;
}