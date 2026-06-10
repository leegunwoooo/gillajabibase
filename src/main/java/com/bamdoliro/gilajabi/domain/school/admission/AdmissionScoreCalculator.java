package com.bamdoliro.gilajabi.domain.school.admission;

import com.bamdoliro.gilajabi.presentation.school.dto.request.AdmissionScoreRequest;
import com.bamdoliro.gilajabi.presentation.school.dto.response.AdmissionScoreResponse;

public interface AdmissionScoreCalculator {
    String getSupportedSchoolId();
    AdmissionScoreResponse calculate(AdmissionScoreRequest request);
}
