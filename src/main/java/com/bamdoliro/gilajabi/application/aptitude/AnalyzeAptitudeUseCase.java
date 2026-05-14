package com.bamdoliro.gilajabi.application.aptitude;

import com.bamdoliro.gilajabi.domain.aptitude.constant.AptitudeQuestions;
import com.bamdoliro.gilajabi.domain.job.entity.JobCategory;
import com.bamdoliro.gilajabi.global.annotation.UseCase;
import com.bamdoliro.gilajabi.presentation.aptitude.dto.request.AptitudeAnswerRequest;
import com.bamdoliro.gilajabi.presentation.aptitude.dto.response.AptitudeResultResponse;
import com.bamdoliro.gilajabi.presentation.aptitude.dto.response.JobRecommendResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.Arrays;

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

        // 1-1. 카테고리 점수를 전체 합 대비 퍼센트로 정규화 (합산 = 100)
        int totalCategoryScore = scores.values().stream().mapToInt(Integer::intValue).sum();
        Map<String, Integer> categoryRates = new LinkedHashMap<>();
        if (totalCategoryScore > 0) {
            List<String> categoryKeys = new ArrayList<>(scores.keySet());
            int[] catRawRates = categoryKeys.stream()
                    .mapToInt(k -> (int) Math.floor((double) scores.get(k) / totalCategoryScore * 100))
                    .toArray();
            int catRemainder = 100 - Arrays.stream(catRawRates).sum();
            if (catRemainder > 0 && catRawRates.length > 0) catRawRates[0] += catRemainder;
            for (int i = 0; i < categoryKeys.size(); i++) {
                categoryRates.put(categoryKeys.get(i), catRawRates[i]);
            }
        }

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

        // 추천 직업들의 점수 합 계산
        int totalScore = includedJobIds.stream()
                .mapToInt(jobId -> scores.getOrDefault(jobId, 0))
                .sum();

        // 각 직업의 matchRate를 전체 합 100%로 정규화
        List<String> jobIdList = new ArrayList<>(includedJobIds);
        int[] rawRates = jobIdList.stream()
                .mapToInt(jobId -> {
                    int score = scores.getOrDefault(jobId, 0);
                    return totalScore > 0 ? (int) Math.floor((double) score / totalScore * 100) : 0;
                })
                .toArray();

        // 반올림 오차로 합이 100이 안 될 경우, 나머지를 가장 점수 높은 직업에 추가
        int rateSum = Arrays.stream(rawRates).sum();
        int remainder = 100 - rateSum;
        if (remainder > 0 && rawRates.length > 0) {
            rawRates[0] += remainder;
        }

        List<JobRecommendResponse> recommended = new ArrayList<>();
        for (int i = 0; i < jobIdList.size(); i++) {
            String jobId = jobIdList.get(i);
            int score = scores.getOrDefault(jobId, 0);
            int matchRate = rawRates[i];
            JobCategory.findById(jobId)
                    .map(job -> JobRecommendResponse.builder()
                            .jobId(job.id)
                            .jobName(job.name)
                            .field(job.field)
                            .icon(job.icon)
                            .score(score)
                            .matchRate(matchRate)
                            .build())
                    .ifPresent(recommended::add);
        }

        return AptitudeResultResponse.builder()
                .categoryScores(scores)
                .categoryRates(categoryRates)
                .recommendedJobs(recommended)
                .build();
    }
}
