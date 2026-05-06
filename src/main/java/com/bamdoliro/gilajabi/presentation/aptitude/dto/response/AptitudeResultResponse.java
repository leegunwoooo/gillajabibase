package com.bamdoliro.gilajabi.presentation.aptitude.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@Builder
public class AptitudeResultResponse {
    private Map<String, Integer> categoryScores;
    private List<JobRecommendResponse> recommendedJobs;
}
