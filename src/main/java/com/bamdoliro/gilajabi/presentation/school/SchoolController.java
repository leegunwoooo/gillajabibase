package com.bamdoliro.gilajabi.presentation.school;

import com.bamdoliro.gilajabi.application.school.CompareSchoolsUseCase;
import com.bamdoliro.gilajabi.application.school.GetAllSchoolsUseCase;
import com.bamdoliro.gilajabi.application.school.GetSchoolDetailUseCase;
import com.bamdoliro.gilajabi.application.school.GetSchoolRecommendUseCase;
import com.bamdoliro.gilajabi.presentation.aptitude.dto.response.SchoolRecommendResponse;
import com.bamdoliro.gilajabi.presentation.school.dto.response.SchoolCompareResponse;
import com.bamdoliro.gilajabi.presentation.school.dto.response.SchoolDetailResponse;
import com.bamdoliro.gilajabi.presentation.school.dto.response.SchoolSummaryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schools")
public class SchoolController {

    private final GetSchoolRecommendUseCase getSchoolRecommendUseCase;
    private final CompareSchoolsUseCase compareSchoolsUseCase;
    private final GetAllSchoolsUseCase getAllSchoolsUseCase;
    private final GetSchoolDetailUseCase getSchoolDetailUseCase;

    @GetMapping
    public ResponseEntity<List<SchoolSummaryResponse>> getAll() {
        return ResponseEntity.ok(getAllSchoolsUseCase.execute());
    }

    @GetMapping("/{schoolId}")
    public ResponseEntity<SchoolDetailResponse> getDetail(@PathVariable String schoolId) {
        return ResponseEntity.ok(getSchoolDetailUseCase.execute(schoolId));
    }

    @GetMapping("/recommend/{jobId}")
    public ResponseEntity<List<SchoolRecommendResponse>> recommend(@PathVariable String jobId) {
        return ResponseEntity.ok(getSchoolRecommendUseCase.execute(jobId));
    }

    @GetMapping("/compare")
    public ResponseEntity<SchoolCompareResponse> compare(
            @RequestParam String school1,
            @RequestParam String school2
    ) {
        return ResponseEntity.ok(compareSchoolsUseCase.execute(school1, school2));
    }
}
