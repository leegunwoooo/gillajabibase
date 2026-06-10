package com.bamdoliro.gilajabi.presentation.school.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AdmissionScoreResponse {

    private String schoolName;
    private String admissionType;
    private ScoreBreakdown breakdown;
    private double totalScore;
    private double maxTotalScore;

    @Getter
    @Builder
    public static class ScoreBreakdown {
        private double subjectScore;
        private double maxSubjectScore;
        private double attendanceScore;
        private double maxAttendanceScore;
        private double volunteerScore;
        private double maxVolunteerScore;
        private double bonusScore;
        private double maxBonusScore;
    }
}
