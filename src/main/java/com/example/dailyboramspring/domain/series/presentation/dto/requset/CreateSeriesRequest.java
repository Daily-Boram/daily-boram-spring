package com.example.dailyboramspring.domain.series.presentation.dto.requset;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@NoArgsConstructor
public class CreateSeriesRequest {

    @NotBlank(message = "제목에 공백이 들어갈 수 없습니다.")
    private String title;

    @NotBlank(message = "요약에 공백이 들어갈 수 없습니다.")
    private String summary;

    @NotBlank(message = "이미지를 넣어주세요")
    private String url;

    private List<String> genre;
}
