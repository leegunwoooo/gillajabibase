package com.bamdoliro.gilajabi.presentation.school.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class AdmissionScoreRequest {

    private List<SubjectScore> grade2Semester1;
    private List<SubjectScore> grade2Semester2;
    private List<SubjectScore> grade3Semester1;

    private int unauthorizedAbsenceDays;
    private int unauthorizedTardyCount;
    private int unauthorizedEarlyLeaveCount;
    private int unauthorizedMissedClassCount;

    private int volunteerHours;

    private CertificateType certificate;

    @Getter
    @NoArgsConstructor
    public static class SubjectScore {
        private String subjectName;
        private AchievementLevel achievement;
        private boolean isMathSubject;
    }

    public enum AchievementLevel {
        A(1), B(2), C(3), D(4), E(5);

        public final int value;

        AchievementLevel(int value) {
            this.value = value;
        }
    }

    public enum CertificateType {
        INFORMATION_PROCESSING,      // 정보처리기능사
        INFORMATION_DEVICE_OPERATION, // 정보기기운용기능사
        ELECTRONIC_COMPUTER,          // 전자계산기기능사
        COMPUTER_USAGE_1,             // 컴퓨터활용능력 1급
        COMPUTER_USAGE_2,             // 컴퓨터활용능력 2급
        COMPUTER_USAGE_3,             // 컴퓨터활용능력 3급
        NONE
    }
}
