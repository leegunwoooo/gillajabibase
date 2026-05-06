package com.bamdoliro.gilajabi.application.aptitude;

import com.bamdoliro.gilajabi.domain.aptitude.constant.AptitudeQuestions;
import com.bamdoliro.gilajabi.global.annotation.UseCase;
import com.bamdoliro.gilajabi.presentation.aptitude.dto.response.QuestionResponse;

import java.util.List;
import java.util.stream.Collectors;

@UseCase
public class GetQuestionsUseCase {

    public List<QuestionResponse> execute() {
        return AptitudeQuestions.QUESTIONS.stream()
                .map(q -> QuestionResponse.builder()
                        .id(q.id())
                        .text(q.text())
                        .build())
                .collect(Collectors.toList());
    }
}
