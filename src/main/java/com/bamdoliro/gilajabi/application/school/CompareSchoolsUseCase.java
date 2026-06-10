package com.bamdoliro.gilajabi.application.school;

import com.bamdoliro.gilajabi.domain.school.entity.MeisterSchool;
import com.bamdoliro.gilajabi.global.ai.GeminiAiService;
import com.bamdoliro.gilajabi.global.annotation.UseCase;
import com.bamdoliro.gilajabi.presentation.school.dto.response.SchoolCompareResponse;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@UseCase
@RequiredArgsConstructor
public class CompareSchoolsUseCase {

    private final GeminiAiService geminiAiService;

    public SchoolCompareResponse execute(String schoolId1, String schoolId2) {
        MeisterSchool school1 = findById(schoolId1);
        MeisterSchool school2 = findById(schoolId2);

        SchoolCompareResponse.SchoolDetail detail1 = toDetail(school1);
        SchoolCompareResponse.SchoolDetail detail2 = toDetail(school2);
        String aiSummary = geminiAiService.generateCompareComment(detail1, detail2);

        return SchoolCompareResponse.builder()
                .school1(detail1)
                .school2(detail2)
                .aiSummary(aiSummary)
                .build();
    }

    private MeisterSchool findById(String id) {
        return Arrays.stream(MeisterSchool.values())
                .filter(s -> s.id.equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학교 ID: " + id));
    }

    private SchoolCompareResponse.SchoolDetail toDetail(MeisterSchool school) {
        return SchoolCompareResponse.SchoolDetail.builder()
                .schoolId(school.id)
                .schoolName(school.name)
                .location(school.location)
                .industryField(school.industryField)
                .icon(school.getIcon())
                .hasDormitory(school.hasDormitory)
                .capacity(school.capacity)
                .competitionRate(school.competitionRate)
                .mainJobs(school.mainJobs)
                .jobFields(school.jobFields)
                .build();
    }
}
