package com.bamdoliro.gilajabi.application.school;

import com.bamdoliro.gilajabi.domain.job.entity.JobCategory;
import com.bamdoliro.gilajabi.domain.school.entity.MeisterSchool;
import com.bamdoliro.gilajabi.global.annotation.UseCase;
import com.bamdoliro.gilajabi.presentation.aptitude.dto.response.SchoolRecommendResponse;

import java.util.List;
import java.util.stream.Collectors;

@UseCase
public class GetSchoolRecommendUseCase {

    public List<SchoolRecommendResponse> execute(String jobId) {
        String field = JobCategory.findById(jobId)
                .map(job -> job.field)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 직업 ID: " + jobId));

        return MeisterSchool.findByJobField(field).stream()
                .map(school -> SchoolRecommendResponse.builder()
                        .schoolId(school.id)
                        .schoolName(school.name)
                        .location(school.location)
                        .industryField(school.industryField)
                        .build())
                .collect(Collectors.toList());
    }
}
