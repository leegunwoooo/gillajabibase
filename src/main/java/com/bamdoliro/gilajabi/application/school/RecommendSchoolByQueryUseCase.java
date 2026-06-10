package com.bamdoliro.gilajabi.application.school;

import com.bamdoliro.gilajabi.global.ai.GeminiAiService;
import com.bamdoliro.gilajabi.global.annotation.UseCase;
import com.bamdoliro.gilajabi.presentation.school.dto.response.SchoolChatResponse;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class RecommendSchoolByQueryUseCase {

    private final GeminiAiService geminiAiService;

    public SchoolChatResponse execute(String query) {
        String answer = geminiAiService.recommendSchoolByQuery(query);
        return SchoolChatResponse.builder()
                .answer(answer)
                .build();
    }
}
