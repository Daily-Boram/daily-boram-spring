package com.example.dailyboramspring.domain.profile.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class UserProfileResponse {

    private String nickname;

    private String image;

    private String introduce;

    private List<SeriesElement> noticeList;

}
