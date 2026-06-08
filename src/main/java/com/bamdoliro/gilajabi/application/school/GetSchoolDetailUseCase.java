package com.bamdoliro.gilajabi.application.school;

import com.bamdoliro.gilajabi.domain.school.entity.MeisterSchool;
import com.bamdoliro.gilajabi.global.annotation.UseCase;
import com.bamdoliro.gilajabi.presentation.school.dto.response.SchoolDetailResponse;

import java.util.Arrays;

@UseCase
public class GetSchoolDetailUseCase {

    public SchoolDetailResponse execute(String schoolId) {
        MeisterSchool school = Arrays.stream(MeisterSchool.values())
                .filter(s -> s.id.equals(schoolId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학교 ID: " + schoolId));

        return SchoolDetailResponse.builder()
                .schoolId(school.id)
                .schoolName(school.name)
                .location(school.location)
                .industryField(school.industryField)
                .icon(school.getIcon())
                .website(school.website)
                .hasDormitory(school.hasDormitory)
                .capacity(school.capacity)
                .competitionRate(school.competitionRate)
                .mainJobs(school.mainJobs)
                .jobFields(school.jobFields)
                .build();
    }
}
