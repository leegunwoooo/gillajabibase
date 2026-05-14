package com.bamdoliro.gilajabi.presentation.school;

import com.bamdoliro.gilajabi.application.school.GetSchoolRecommendUseCase;
import com.bamdoliro.gilajabi.presentation.aptitude.dto.response.SchoolRecommendResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schools")
public class SchoolController {

    private final GetSchoolRecommendUseCase getSchoolRecommendUseCase;

    @GetMapping("/recommend/{jobId}")
    public ResponseEntity<List<SchoolRecommendResponse>> recommend(@PathVariable String jobId) {
        return ResponseEntity.ok(getSchoolRecommendUseCase.execute(jobId));
    }
}
