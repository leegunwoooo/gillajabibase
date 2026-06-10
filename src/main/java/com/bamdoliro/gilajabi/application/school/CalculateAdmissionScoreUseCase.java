package com.bamdoliro.gilajabi.application.school;

import com.bamdoliro.gilajabi.domain.school.admission.AdmissionScoreCalculator;
import com.bamdoliro.gilajabi.global.annotation.UseCase;
import com.bamdoliro.gilajabi.presentation.school.dto.request.AdmissionScoreRequest;
import com.bamdoliro.gilajabi.presentation.school.dto.response.AdmissionScoreResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class CalculateAdmissionScoreUseCase {

    private final List<AdmissionScoreCalculator> calculators;

    public AdmissionScoreResponse execute(String schoolId, AdmissionScoreRequest request) {
        return calculators.stream()
                .filter(c -> c.getSupportedSchoolId().equals(schoolId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("입학 점수 계산이 지원되지 않는 학교입니다: " + schoolId))
                .calculate(request);
    }
}
