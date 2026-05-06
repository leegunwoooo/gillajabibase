package com.bamdoliro.gilajabi.domain.aptitude.constant;

import java.util.List;

public class AptitudeQuestions {

    public record Weight(String jobId, int score) {}

    public record Question(int id, String text, List<Weight> weights) {}

    public static final List<Question> QUESTIONS = List.of(
        new Question(1, "새로운 프로그래밍 언어나 기술을 배우는 것이 즐겁다.", List.of(
            new Weight("SW001", 3), new Weight("AI001", 3), new Weight("DA001", 2)
        )),
        new Question(2, "데이터를 분석하고 패턴을 찾는 작업이 흥미롭다.", List.of(
            new Weight("DA001", 3), new Weight("AI001", 3), new Weight("RS001", 2)
        )),
        new Question(3, "시각적으로 아름다운 것을 만드는 작업이 좋다.", List.of(
            new Weight("DE001", 3), new Weight("DE002", 3), new Weight("CC001", 2)
        )),
        new Question(4, "사람들에게 무언가를 설명하거나 가르치는 것을 즐긴다.", List.of(
            new Weight("ED001", 3), new Weight("CC001", 2), new Weight("MK001", 1)
        )),
        new Question(5, "프로젝트를 계획하고 팀을 이끄는 역할이 맞다.", List.of(
            new Weight("PM001", 3), new Weight("MK001", 2), new Weight("ED001", 1)
        )),
        new Question(6, "논리적으로 문제를 분석하고 해결책을 찾는 것이 즐겁다.", List.of(
            new Weight("SW001", 3), new Weight("DA001", 2), new Weight("RS001", 3)
        )),
        new Question(7, "사람들의 심리와 행동 방식에 관심이 많다.", List.of(
            new Weight("MK001", 3), new Weight("DE001", 2), new Weight("ED001", 2)
        )),
        new Question(8, "실험을 설계하고 결과를 검증하는 작업이 흥미롭다.", List.of(
            new Weight("RS001", 3), new Weight("AI001", 2), new Weight("DA001", 2)
        )),
        new Question(9, "영상이나 글로 나의 생각을 표현하는 것이 좋다.", List.of(
            new Weight("CC001", 3), new Weight("MK001", 2), new Weight("DE002", 1)
        )),
        new Question(10, "사용자 경험(UX)을 개선하는 작업에 흥미를 느낀다.", List.of(
            new Weight("DE001", 3), new Weight("PM001", 2), new Weight("SW001", 1)
        ))
    );

    private AptitudeQuestions() {}
}
