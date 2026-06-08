package com.bamdoliro.gilajabi.presentation.school.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SchoolSummaryResponse {
    private String schoolId;
    private String schoolName;
    private String location;
    private String industryField;
    private String icon;
    private String website;
    private boolean hasDormitory;
    private int capacity;
    private String competitionRate;
}
