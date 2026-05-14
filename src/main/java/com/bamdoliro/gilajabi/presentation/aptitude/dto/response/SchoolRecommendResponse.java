package com.bamdoliro.gilajabi.presentation.aptitude.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SchoolRecommendResponse {
    private String schoolId;
    private String schoolName;
    private String location;
    private String industryField;
}
