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

        // 3. 점수 높은 순 전체 정렬
        List<Map.Entry<String, Integer>> sorted = scores.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .toList();

        // 4. 1위 직업의 field 확인 → 해당 field 직업 무조건 포함
        String topField = sorted.stream()
                .map(e -> JobCategory.findById(e.getKey()))
                .filter(Optional::isPresent)
                .map(opt -> opt.get().field)
                .findFirst()
                .orElse("");

        Set<String> includedJobIds = new LinkedHashSet<>();

        // 1위 field 직업 먼저 추가
        for (Map.Entry<String, Integer> entry : sorted) {
            JobCategory.findById(entry.getKey())
                    .filter(job -> job.field.equals(topField))
                    .ifPresent(job -> includedJobIds.add(job.id));
        }

        // 나머지 슬롯을 다른 field 상위 직업으로 채워 총 4개 맞춤
        for (Map.Entry<String, Integer> entry : sorted) {
            if (includedJobIds.size() >= 4) break;
            JobCategory.findById(entry.getKey())
                    .filter(job -> !job.field.equals(topField))
                    .ifPresent(job -> includedJobIds.add(job.id));
        }

        List<JobRecommendResponse> recommended = includedJobIds.stream()
                .map(jobId -> {
                    int score = scores.getOrDefault(jobId, 0);
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
