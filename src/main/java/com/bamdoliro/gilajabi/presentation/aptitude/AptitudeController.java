package com.bamdoliro.gilajabi.presentation.aptitude;

import com.bamdoliro.gilajabi.application.aptitude.AnalyzeAptitudeUseCase;
import com.bamdoliro.gilajabi.application.aptitude.GetQuestionsUseCase;
import com.bamdoliro.gilajabi.presentation.aptitude.dto.request.AptitudeAnswerRequest;
import com.bamdoliro.gilajabi.presentation.aptitude.dto.response.AptitudeResultResponse;
import com.bamdoliro.gilajabi.presentation.aptitude.dto.response.QuestionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/aptitude")
public class AptitudeController {

    private final GetQuestionsUseCase getQuestionsUseCase;
    private final AnalyzeAptitudeUseCase analyzeAptitudeUseCase;

    @GetMapping("/questions")
    public ResponseEntity<List<QuestionResponse>> getQuestions() {
        return ResponseEntity.ok(getQuestionsUseCase.execute());
    }

    @PostMapping("/analyze")
    public ResponseEntity<AptitudeResultResponse> analyze(@RequestBody AptitudeAnswerRequest request) {
        return ResponseEntity.ok(analyzeAptitudeUseCase.execute(request));
    }
}
