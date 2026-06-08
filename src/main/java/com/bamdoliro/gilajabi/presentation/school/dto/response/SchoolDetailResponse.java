package com.bamdoliro.gilajabi.presentation.school.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class SchoolDetailResponse {
    private String schoolId;
    private String schoolName;
    private String location;
    private String industryField;
    private String icon;
    private String website;
    private boolean hasDormitory;
    private int capacity;
    private String competitionRate;
    private List<String> mainJobs;
    private List<String> jobFields;
}
