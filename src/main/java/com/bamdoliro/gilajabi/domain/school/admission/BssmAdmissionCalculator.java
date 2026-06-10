package com.bamdoliro.gilajabi.domain.school.admission;

import com.bamdoliro.gilajabi.presentation.school.dto.request.AdmissionScoreRequest;
import com.bamdoliro.gilajabi.presentation.school.dto.response.AdmissionScoreResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BssmAdmissionCalculator implements AdmissionScoreCalculator {

    private static final String SCHOOL_ID = "MS008";

    @Override
    public String getSupportedSchoolId() {
        return SCHOOL_ID;
    }

    @Override
    public AdmissionScoreResponse calculate(AdmissionScoreRequest request) {
        double subjectScore = calculateSubjectScore(request);
        double attendanceScore = calculateAttendanceScore(request);
        double volunteerScore = calculateVolunteerScore(request.getVolunteerHours());
        double bonusScore = calculateBonusScore(request.getCertificate());

        double total = subjectScore + attendanceScore + volunteerScore + bonusScore;

        return AdmissionScoreResponse.builder()
                .schoolName("부산소프트웨어마이스터고")
                .admissionType("일반전형")
                .breakdown(AdmissionScoreResponse.ScoreBreakdown.builder()
                        .subjectScore(round(subjectScore))
                        .maxSubjectScore(200)
                        .attendanceScore(round(attendanceScore))
                        .maxAttendanceScore(18)
                        .volunteerScore(round(volunteerScore))
                        .maxVolunteerScore(18)
                        .bonusScore(round(bonusScore))
                        .maxBonusScore(4)
                        .build())
                .totalScore(round(total))
                .maxTotalScore(240)
                .build();
    }

    // 교과성적: 80 + 4.8*(S21/N21 + S22/N22) + 7.2*2*(S31/N31), max 200
    private double calculateSubjectScore(AdmissionScoreRequest request) {
        double s21 = weightedSum(request.getGrade2Semester1());
        int n21 = subjectCount(request.getGrade2Semester1());

        double s22 = weightedSum(request.getGrade2Semester2());
        int n22 = subjectCount(request.getGrade2Semester2());

        double s31 = weightedSum(request.getGrade3Semester1());
        int n31 = subjectCount(request.getGrade3Semester1());

        double ratio21 = n21 > 0 ? s21 / n21 : 0;
        double ratio22 = n22 > 0 ? s22 / n22 : 0;
        double ratio31 = n31 > 0 ? s31 / n31 : 0;

        double score = 80 + 4.8 * (ratio21 + ratio22) + 7.2 * 2 * ratio31;
        return Math.min(score, 200);
    }

    // 가중합: 수학 과목은 2배 가중
    private double weightedSum(List<AdmissionScoreRequest.SubjectScore> subjects) {
        if (subjects == null) return 0;
        return subjects.stream()
                .mapToDouble(s -> {
                    int weight = s.isMathSubject() ? 2 : 1;
                    return weight * (6 - s.getAchievement().value); // A=5점, E=1점 (6-rank)
                })
                .sum();
    }

    // 과목 수: 수학은 2배로 카운트
    private int subjectCount(List<AdmissionScoreRequest.SubjectScore> subjects) {
        if (subjects == null) return 0;
        return subjects.stream()
                .mapToInt(s -> s.isMathSubject() ? 2 : 1)
                .sum();
    }

    // 출결: 18점 기준, 결석일수당 -1점 (지각/조퇴/결과 3회=결석1일), 16일 이상=0점
    private double calculateAttendanceScore(AdmissionScoreRequest request) {
        int convertedAbsence = (request.getUnauthorizedTardyCount()
                + request.getUnauthorizedEarlyLeaveCount()
                + request.getUnauthorizedMissedClassCount()) / 3;
        int totalAbsenceDays = request.getUnauthorizedAbsenceDays() + convertedAbsence;

        if (totalAbsenceDays >= 16) return 0;
        return Math.max(0, 18 - totalAbsenceDays);
    }

    // 봉사: 18점 기준, 30시간 미달시 시간당 -0.5점, 15시간 미만=0점
    private double calculateVolunteerScore(int hours) {
        if (hours < 15) return 0;
        if (hours >= 30) return 18;
        return 18 - (30 - hours) * 0.5;
    }

    // 가산점: 정보처리기능사/정보기기운용/전자계산기기능사=4점, 컴활1급=3점, 2급=2점, 3급=1점
    private double calculateBonusScore(AdmissionScoreRequest.CertificateType cert) {
        if (cert == null || cert == AdmissionScoreRequest.CertificateType.NONE) return 0;
        return switch (cert) {
            case INFORMATION_PROCESSING, INFORMATION_DEVICE_OPERATION, ELECTRONIC_COMPUTER -> 4;
            case COMPUTER_USAGE_1 -> 3;
            case COMPUTER_USAGE_2 -> 2;
            case COMPUTER_USAGE_3 -> 1;
            default -> 0;
        };
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
