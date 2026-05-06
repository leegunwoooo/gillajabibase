package com.bamdoliro.gilajabi.presentation.aptitude.dto.request;

import lombok.Getter;

import java.util.Map;

@Getter
public class AptitudeAnswerRequest {
    private Map<Integer, Integer> answers;
}
