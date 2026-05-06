package com.bamdoliro.gilajabi.application.aptitude;

import com.bamdoliro.gilajabi.domain.aptitude.constant.AptitudeQuestions;
import com.bamdoliro.gilajabi.domain.job.entity.JobCategory;
import com.bamdoliro.gilajabi.global.annotation.UseCase;
import com.bamdoliro.gilajabi.presentation.aptitude.dto.request.AptitudeAnswerRequest;
import com.bamdoliro.gilajabi.presentation.aptitude.dto.response.AptitudeResultResponse;
import com.bamdoliro.gilajabi.presentation.aptitude.dto.response.JobRecommendResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@UseCase
public class AnalyzeAptitudeUseCase {

    public AptitudeResultResponse execute(AptitudeAnswerRequest request) {
        Map<Integer, Integer> answers = request.getAnswers();

        // 1. 카테고리별 점수 합산: 응답 점수(1~5) × 가중치(1~3) 누적
        Map<String, Integer> scores = new HashMap<>();
        for (AptitudeQuestions.Question question : AptitudeQuestions.QUESTIONS) {
            int answer = answers.getOrDefault(question.id(), 3);
            for (AptitudeQuestions.Weight weight : question.weights()) {
                scores.merge(weight.jobId(), answer * weight.score(), Integer::sum);
            }
        }

        log.info("카테고리별 점수: {}", scores);

        // 2. 최대 가능 점수 계산 (5점 만점 × 가중치 합)
        Map<String, Integer> maxScores = new HashMap<>();
        for (AptitudeQuestions.Question question : AptitudeQuestions.QUESTIONS) {
            for (AptitudeQuestions.Weight weight : question.weights()) {
                maxScores.merge(weight.jobId(), 5 * weight.score(), Integer::sum);
            }
        }

        // 3. 점수 높은 순 정렬 → 상위 3개 직업 추출
        List<JobRecommendResponse> recommended = scores.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .map(entry -> {
                    String jobId = entry.getKey();
                    int score = entry.getValue();
                    int maxScore = maxScores.getOrDefault(jobId, 1);
                    int matchRate = Math.min(100, (int) Math.round((double) score / maxScore * 100));

                    return JobCategory.findById(jobId)
                            .map(job -> JobRecommendResponse.builder()
                                    .jobId(job.id)
                                    .jobName(job.name)
                                    .field(job.field)
                                    .icon(job.icon)
                                    .score(score)
                                    .matchRate(matchRate)
                                    .build())
                            .orElse(null);
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return AptitudeResultResponse.builder()
                .categoryScores(scores)
                .recommendedJobs(recommended)
                .build();
    }
}
