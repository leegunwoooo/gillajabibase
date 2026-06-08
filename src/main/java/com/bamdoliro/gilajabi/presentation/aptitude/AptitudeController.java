package com.bamdoliro.gilajabi.presentation.aptitude;

import com.bamdoliro.gilajabi.application.aptitude.AnalyzeAptitudeUseCase;
import com.bamdoliro.gilajabi.application.aptitude.GetQuestionsUseCase;
import com.bamdoliro.gilajabi.presentation.aptitude.dto.request.AptitudeAnswerRequest;
import com.bamdoliro.gilajabi.presentation.aptitude.dto.response.AptitudeResultResponse;
import com.bamdoliro.gilajabi.presentation.aptitude.dto.response.QuestionResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/aptitude")
public class AptitudeController {

    private static final String SESSION_KEY = "aptitudeResult";
    private static final String SESSION_PROGRESS_KEY = "aptitudeProgress";

    private final GetQuestionsUseCase getQuestionsUseCase;
    private final AnalyzeAptitudeUseCase analyzeAptitudeUseCase;

    @GetMapping("/questions")
    public ResponseEntity<List<QuestionResponse>> getQuestions() {
        return ResponseEntity.ok(getQuestionsUseCase.execute());
    }

    @PostMapping("/analyze")
    public ResponseEntity<AptitudeResultResponse> analyze(
            @RequestBody AptitudeAnswerRequest request,
            HttpSession session
    ) {
        AptitudeResultResponse result = analyzeAptitudeUseCase.execute(request);
        session.setAttribute(SESSION_KEY, result);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/result")
    public ResponseEntity<AptitudeResultResponse> getResult(HttpSession session) {
        AptitudeResultResponse result = (AptitudeResultResponse) session.getAttribute(SESSION_KEY);
        if (result == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/result")
    public ResponseEntity<Void> clearResult(HttpSession session) {
        session.removeAttribute(SESSION_KEY);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/progress")
    public ResponseEntity<Void> saveProgress(
            @RequestBody AptitudeAnswerRequest request,
            HttpSession session
    ) {
        session.setAttribute(SESSION_PROGRESS_KEY, request.getAnswers());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/progress")
    public ResponseEntity<Map<Integer, Integer>> getProgress(HttpSession session) {
        @SuppressWarnings("unchecked")
        Map<Integer, Integer> progress = (Map<Integer, Integer>) session.getAttribute(SESSION_PROGRESS_KEY);
        if (progress == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(progress);
    }

    @DeleteMapping("/progress")
    public ResponseEntity<Void> clearProgress(HttpSession session) {
        session.removeAttribute(SESSION_PROGRESS_KEY);
        return ResponseEntity.noContent().build();
    }
}
