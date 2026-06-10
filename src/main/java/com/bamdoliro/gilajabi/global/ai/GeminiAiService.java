package com.bamdoliro.gilajabi.global.ai;

import com.bamdoliro.gilajabi.domain.school.entity.MeisterSchool;
import com.bamdoliro.gilajabi.presentation.aptitude.dto.response.JobRecommendResponse;
import com.bamdoliro.gilajabi.presentation.school.dto.response.SchoolCompareResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GeminiAiService {

    private static final String API_URL = "https://generativelanguage.googleapis.com";
    private static final String MODEL = "gemini-2.5-flash";

    private final RestClient restClient;
    private final String apiKey;

    public GeminiAiService(@Value("${gemini.api-key}") String apiKey) {
        this.apiKey = apiKey;
        this.restClient = RestClient.builder()
                .baseUrl(API_URL)
                .defaultHeader("content-type", MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public String generateAptitudeComment(List<JobRecommendResponse> recommendedJobs) {
        try {
            String jobList = recommendedJobs.stream()
                    .map(j -> "%s(%s, 적합도 %d%%)".formatted(j.getJobName(), j.getField(), j.getMatchRate()))
                    .collect(Collectors.joining(", "));

            String prompt = """
                    당신은 마이스터고 진로 가이드입니다. 학생의 적성 검사 결과를 바탕으로 강점과 진로 방향을 친근하게 설명해주세요.

                    적성 검사 결과 추천 직업: %s
                    위 결과를 바탕으로 중학생에게 따뜻하고 격려적인 피드백을 3문장으로 작성해주세요.
                    마크다운 없이 순수 텍스트로만 작성해주세요.
                    """.formatted(jobList);

            return callGemini(prompt);
        } catch (Exception e) {
            log.error("적성 분석 AI 코멘트 생성 실패", e);
            return null;
        }
    }

    public String generateCompareComment(SchoolCompareResponse.SchoolDetail school1, SchoolCompareResponse.SchoolDetail school2) {
        try {
            String prompt = """
                    당신은 마이스터고 진로 가이드입니다. 두 학교의 특성을 비교하여 학생이 자신에게 맞는 학교를 선택하도록 도와주세요.

                    두 마이스터고를 비교해주세요.

                    [%s]
                    - 특화 분야: %s
                    - 주요 직업: %s
                    - 직업 분류: %s
                    - 경쟁률: %s

                    [%s]
                    - 특화 분야: %s
                    - 주요 직업: %s
                    - 직업 분류: %s
                    - 경쟁률: %s

                    각 학교가 어떤 성향의 학생에게 더 적합한지 각각 2문장씩 설명해주세요.
                    마크다운 없이 순수 텍스트로만 작성해주세요.
                    """.formatted(
                    school1.getSchoolName(), school1.getIndustryField(),
                    String.join(", ", school1.getMainJobs()), String.join(", ", school1.getJobFields()),
                    school1.getCompetitionRate() != null ? school1.getCompetitionRate() : "미공개",
                    school2.getSchoolName(), school2.getIndustryField(),
                    String.join(", ", school2.getMainJobs()), String.join(", ", school2.getJobFields()),
                    school2.getCompetitionRate() != null ? school2.getCompetitionRate() : "미공개"
            );

            return callGemini(prompt);
        } catch (Exception e) {
            log.error("학교 비교 AI 요약 생성 실패", e);
            return null;
        }
    }

    public String recommendSchoolByQuery(String query) {
        try {
            String schoolData = buildSchoolContext();

            String prompt = """
                    당신은 마이스터고 진로 가이드입니다. 아래 학교 목록만을 근거로 학생의 질문에 맞는 학교를 추천해주세요.
                    목록에 없는 학교는 절대 언급하지 마세요.

                    [마이스터고 목록]
                    %s

                    [학생 질문]
                    %s

                    추천 학교와 이유를 2~3개 학교로 간결하게 설명해주세요. 마크다운 없이 순수 텍스트로만 작성해주세요.
                    """.formatted(schoolData, query);

            return callGemini(prompt);
        } catch (Exception e) {
            log.error("자연어 학교 추천 생성 실패", e);
            return null;
        }
    }

    private String buildSchoolContext() {
        return java.util.Arrays.stream(MeisterSchool.values())
                .map(s -> "%s(%s) - %s | 주요직업: %s | 분야: %s".formatted(
                        s.name, s.location, s.industryField,
                        String.join(", ", s.mainJobs),
                        String.join(", ", s.jobFields)
                ))
                .collect(Collectors.joining("\n"));
    }

    private String callGemini(String prompt) {
        Map<String, Object> body = Map.of(
                "contents", List.of(Map.of(
                        "parts", List.of(Map.of("text", prompt))
                ))
        );

        GeminiResponse response = restClient.post()
                .uri("/v1beta/models/{model}:generateContent?key={key}", MODEL, apiKey)
                .body(body)
                .retrieve()
                .body(GeminiResponse.class);

        if (response == null || response.candidates() == null || response.candidates().isEmpty()) {
            return null;
        }

        List<Part> parts = response.candidates().get(0).content().parts();
        if (parts == null || parts.isEmpty()) {
            return null;
        }
        return parts.get(0).text();
    }

    record GeminiResponse(List<Candidate> candidates) {}
    record Candidate(Content content) {}
    record Content(List<Part> parts) {}
    record Part(String text) {}
}
