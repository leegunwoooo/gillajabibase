package com.bamdoliro.gilajabi.presentation.aptitude.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@Builder
public class AptitudeResultResponse {
    private Map<String, Integer> categoryScores;
    private Map<String, Integer> categoryRates;
    private List<JobRecommendResponse> recommendedJobs;
    private String aiComment;
}
