package com.bamdoliro.gilajabi.presentation.aptitude.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JobRecommendResponse {
    private String jobId;
    private String jobName;
    private String field;
    private String icon;
    private int score;
    private int matchRate;
}
