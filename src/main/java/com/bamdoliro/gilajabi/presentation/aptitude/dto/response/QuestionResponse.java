package com.bamdoliro.gilajabi.presentation.aptitude.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QuestionResponse {
    private int id;
    private String text;
}
