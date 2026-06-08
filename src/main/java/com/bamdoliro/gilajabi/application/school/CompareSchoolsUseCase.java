package com.bamdoliro.gilajabi.application.school;

import com.bamdoliro.gilajabi.domain.school.entity.MeisterSchool;
import com.bamdoliro.gilajabi.global.annotation.UseCase;
import com.bamdoliro.gilajabi.presentation.school.dto.response.SchoolCompareResponse;

import java.util.Arrays;

@UseCase
public class CompareSchoolsUseCase {

    public SchoolCompareResponse execute(String schoolId1, String schoolId2) {
        MeisterSchool school1 = findById(schoolId1);
        MeisterSchool school2 = findById(schoolId2);

        return SchoolCompareResponse.builder()
                .school1(toDetail(school1))
                .school2(toDetail(school2))
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
                .website(school.website)
                .hasDormitory(school.hasDormitory)
                .capacity(school.capacity)
                .competitionRate(school.competitionRate)
                .mainJobs(school.mainJobs)
                .jobFields(school.jobFields)
                .build();
    }
}
