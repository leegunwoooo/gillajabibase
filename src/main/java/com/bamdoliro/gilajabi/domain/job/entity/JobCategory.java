package com.bamdoliro.gilajabi.domain.job.entity;

import java.util.Arrays;
import java.util.Optional;

public enum JobCategory {
    SW_DEVELOPER("SW001", "소프트웨어 개발자", "IT", "💻"),
    DATA_ANALYST("DA001", "데이터 분석가", "IT", "📊"),
    AI_ENGINEER("AI001", "AI 엔지니어", "IT", "🤖"),
    UI_UX_DESIGNER("DE001", "UI/UX 디자이너", "디자인", "🎨"),
    GRAPHIC_DESIGNER("DE002", "그래픽 디자이너", "디자인", "✏️"),
    MARKETER("MK001", "마케터", "경영", "📣"),
    RESEARCHER("RS001", "연구원", "과학", "🔬"),
    CONTENT_CREATOR("CC001", "콘텐츠 크리에이터", "미디어", "🎬"),
    MECHANICAL_ENGINEER("ME001", "기계 엔지니어", "기계", "⚙️"),
    ELECTRICIAN("EL001", "전기 기술자", "전기/전자", "⚡"),
    COOK("CK001", "조리사", "식품/조리", "🍳"),
    AGRICULTURAL_TECHNICIAN("AG001", "농업 기술자", "농업", "🌱"),
    FOOD_PROCESSOR("AG002", "식품 가공사", "식품/농업", "🥫"),
    NURSING_ASSISTANT("MH001", "간호조무사", "의료/보건", "🏥");

    public final String id;
    public final String name;
    public final String field;
    public final String icon;

    JobCategory(String id, String name, String field, String icon) {
        this.id = id;
        this.name = name;
        this.field = field;
        this.icon = icon;
    }

    public static Optional<JobCategory> findById(String id) {
        return Arrays.stream(values())
                .filter(j -> j.id.equals(id))
                .findFirst();
    }
}
