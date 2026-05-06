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
            new Weight("CC001", 3), new Weight("MK001", 2), new Weight("MH001", 1)
        )),
        new Question(5, "팀을 이끌거나 일을 체계적으로 계획하는 것이 즐겁다.", List.of(
            new Weight("MK001", 3), new Weight("SW001", 2), new Weight("ME001", 1)
        )),
        new Question(6, "논리적으로 문제를 분석하고 해결책을 찾는 것이 즐겁다.", List.of(
            new Weight("SW001", 3), new Weight("DA001", 2), new Weight("RS001", 3)
        )),
        new Question(7, "사람들의 심리와 행동 방식에 관심이 많다.", List.of(
            new Weight("MK001", 3), new Weight("DE001", 2), new Weight("CC001", 2)
        )),
        new Question(8, "실험을 설계하고 결과를 검증하는 작업이 흥미롭다.", List.of(
            new Weight("RS001", 3), new Weight("AI001", 2), new Weight("DA001", 2)
        )),
        new Question(9, "영상이나 글로 나의 생각을 표현하는 것이 좋다.", List.of(
            new Weight("CC001", 3), new Weight("MK001", 2), new Weight("DE002", 1)
        )),
        new Question(10, "사용자 경험(UX)을 개선하는 작업에 흥미를 느낀다.", List.of(
            new Weight("DE001", 3), new Weight("CC001", 2), new Weight("SW001", 1)
        )),
        new Question(11, "기계나 장비를 분해하고 조립하는 것이 재미있다.", List.of(
            new Weight("ME001", 3), new Weight("EL001", 2), new Weight("SW001", 1)
        )),
        new Question(12, "전기·전자 회로나 장치에 흥미가 있다.", List.of(
            new Weight("EL001", 3), new Weight("ME001", 2), new Weight("AI001", 1)
        )),
        new Question(13, "음식을 만들거나 새로운 요리를 시도하는 것을 즐긴다.", List.of(
            new Weight("CK001", 3), new Weight("AG002", 2), new Weight("CC001", 1)
        )),
        new Question(14, "식물을 기르거나 자연환경에 관심이 많다.", List.of(
            new Weight("AG001", 3), new Weight("AG002", 2), new Weight("RS001", 1)
        )),
        new Question(15, "아픈 사람을 돕거나 건강 관련 분야에 관심이 있다.", List.of(
            new Weight("MH001", 3), new Weight("AG001", 1)
        )),
        new Question(16, "손으로 정밀한 작업을 하는 것이 적성에 맞는다.", List.of(
            new Weight("ME001", 3), new Weight("EL001", 2), new Weight("MH001", 2), new Weight("DE002", 1)
        ))
    );

    private AptitudeQuestions() {}
}
