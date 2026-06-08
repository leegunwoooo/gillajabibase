package com.bamdoliro.gilajabi.application.school;

import com.bamdoliro.gilajabi.domain.school.entity.MeisterSchool;
import com.bamdoliro.gilajabi.global.annotation.UseCase;
import com.bamdoliro.gilajabi.presentation.school.dto.response.SchoolSummaryResponse;

import java.util.Arrays;
import java.util.List;

@UseCase
public class GetAllSchoolsUseCase {

    public List<SchoolSummaryResponse> execute() {
        return Arrays.stream(MeisterSchool.values())
                .map(school -> SchoolSummaryResponse.builder()
                        .schoolId(school.id)
                        .schoolName(school.name)
                        .location(school.location)
                        .industryField(school.industryField)
                        .icon(school.getIcon())
                        .website(school.website)
                        .hasDormitory(school.hasDormitory)
                        .capacity(school.capacity)
                        .competitionRate(school.competitionRate)
                        .build())
                .toList();
    }
}
