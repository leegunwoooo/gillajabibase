package com.bamdoliro.gilajabi.domain.school.entity;

import java.util.Arrays;
import java.util.List;

public enum MeisterSchool {

    // 서울
    SUDO_ELECTRIC("MS001", "수도전기공업고", "서울", "에너지", "전기/전자", "과학"),
    MIRIM_GIRLS_IT("MS002", "미림여자정보과학고", "서울", "뉴미디어콘텐츠", "IT", "미디어", "디자인"),
    SEOUL_ROBOT("MS003", "서울로봇고", "서울", "로봇", "기계", "전기/전자"),
    SEOUL_URBAN_TECH("MS004", "서울도시과학기술고", "서울", "해외건설·플랜트", "기계"),

    // 부산
    BUSAN_AUTO("MS005", "부산자동차고", "부산", "자동차산업", "기계"),
    BUSAN_MACHINE("MS006", "부산기계공업고", "부산", "기계", "기계"),
    BUSAN_MARITIME("MS007", "부산해사고", "부산", "해양", "기계"),
    BUSAN_SW("MS008", "부산소프트웨어마이스터고", "부산", "소프트웨어", "IT"),

    // 대구
    GYEONGBUK_MACHINE("MS009", "경북기계공업고", "대구", "기계·메카트로닉스", "기계"),
    DAEGU_IL_MEISTER("MS010", "대구일마이스터고", "대구", "자동차", "기계"),
    DAEGU_SW("MS011", "대구소프트웨어마이스터고", "대구", "SW·SW융합", "IT"),
    DAEGU_AGRI("MS012", "대구농업마이스터고", "대구", "도시형 첨단농업경영", "농업"),

    // 인천
    INCHEON_ELECTRONIC("MS013", "인천전자마이스터고", "인천", "전자·통신", "전기/전자"),
    INCHEON_MARITIME("MS014", "인천해사고", "인천", "해양", "기계"),

    // 광주
    GWANGJU_AUTO("MS015", "광주자동화설비공업고", "광주", "자동화설비", "기계"),
    GWANGJU_SW("MS016", "광주소프트웨어마이스터고", "광주", "소프트웨어", "IT"),

    // 대전
    DONG_A_MEISTER("MS017", "동아마이스터고", "대전", "전자·기계", "전기/전자", "기계"),
    DAEDEOK_SW("MS018", "대덕소프트웨어마이스터고", "대전", "소프트웨어", "IT"),

    // 울산
    ULSAN_MEISTER("MS019", "울산마이스터고", "울산", "기계·자동화", "기계"),
    ULSAN_ENERGY("MS020", "울산에너지고", "울산", "에너지", "과학"),
    HYUNDAI_INDUSTRIAL("MS021", "현대공업고", "울산", "조선해양플랜트", "기계"),

    // 경기
    SUWON_HITECH("MS022", "수원하이텍고", "경기", "메카트로닉스", "기계"),
    PYEONGTAEK_MEISTER("MS023", "평택마이스터고", "경기", "자동차·기계", "기계"),
    GYEONGGI_GAME("MS024", "경기게임마이스터고", "경기", "게임 콘텐츠", "IT", "미디어", "디자인"),

    // 강원
    WONJU_MEDICAL("MS025", "원주의료고", "강원", "의료기기·바이오", "의료/보건"),
    KOREA_ENERGY("MS026", "한국에너지마이스터고", "강원", "발전산업", "과학"),
    KOREA_FIRE("MS027", "한국소방마이스터고", "강원", "소방", "과학"),

    // 충북
    CHUNGBUK_SEMICONDUCTOR("MS028", "충북반도체고", "충북", "반도체장비", "전기/전자", "IT"),
    KOREA_BIO("MS029", "한국바이오마이스터고", "충북", "바이오", "과학", "의료/보건"),
    CHUNGBUK_ENERGY("MS030", "충북에너지고", "충북", "차세대전지", "과학"),

    // 충남
    HAPDEOK_STEEL("MS031", "합덕제철고", "충남", "철강", "기계"),
    GONGJU_MEISTER("MS032", "공주마이스터고", "충남", "전기·전자", "전기/전자"),
    YEONMU_MEISTER("MS033", "연무마이스터고", "충남", "자동차부품제조", "기계"),
    KOREA_FOOD("MS034", "한국식품마이스터고", "충남", "식품", "식품/조리", "식품/농업"),
    ASAN_SMART_FACTORY("MS035", "아산스마트팩토리마이스터고", "충남", "스마트공장", "기계", "IT"),

    // 전북
    GUNSAN_MACHINE("MS036", "군산기계공업고", "전북", "조선·기계", "기계"),
    JEONBUK_MACHINE("MS037", "전북기계공업고", "전북", "기계", "기계"),
    KOREA_HORSE("MS038", "한국경마축산고", "전북", "말 산업", "농업"),
    GIMJE_AGRI("MS039", "김제농생명마이스터고", "전북", "농생명자원생산·가공", "농업", "식품/농업"),

    // 전남
    KOREA_PORT_LOGISTICS("MS040", "한국항만물류고", "전남", "항만물류", "경영"),
    JEONNAM_LIFE_SCIENCE("MS041", "전남생명과학고", "전남", "친환경농축산", "농업", "식품/농업"),
    YEOSU_PETROCHEMICAL("MS042", "여수석유화학고", "전남", "석유화학산업", "과학"),
    WANDO_FISHERIES("MS043", "완도수산고", "전남", "어업 및 수산물 가공", "식품/농업"),

    // 경북
    GUMI_ELECTRONIC("MS044", "구미전자공업고", "경북", "전자", "전기/전자"),
    GEUMOH_INDUSTRIAL("MS045", "금오공업고", "경북", "기계·전자모바일", "기계", "전기/전자"),
    POSCO_INDUSTRIAL("MS046", "포항제철공업고", "경북", "철강", "기계"),
    KOREA_NUCLEAR("MS047", "한국원자력마이스터고", "경북", "원자력발전설비", "과학"),
    GYEONGBUK_BIO("MS048", "경북바이오마이스터고", "경북", "식품품질관리", "식품/농업"),
    KOREA_INTL_TRADE("MS049", "한국국제통상마이스터고", "경북", "글로벌 비즈니스", "경영"),
    KOREA_MARITIME("MS050", "한국해양마이스터고", "경북", "스마트해양수산", "기계"),

    // 경남
    GEOJE_INDUSTRIAL("MS051", "거제공업고", "경남", "조선", "기계"),
    SAMCHEONPO_INDUSTRIAL("MS052", "삼천포공업고", "경남", "항공·조선", "기계"),
    AIR_FORCE_AVIATION("MS053", "공군항공과학고", "경남", "항공기술", "기계"),
    KOREA_NANO("MS054", "한국나노마이스터고", "경남", "나노융합", "과학", "전기/전자");

    public final String id;
    public final String name;
    public final String location;
    public final String industryField;
    public final List<String> jobFields;

    MeisterSchool(String id, String name, String location, String industryField, String... jobFields) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.industryField = industryField;
        this.jobFields = Arrays.asList(jobFields);
    }

    public static List<MeisterSchool> findByJobField(String jobField) {
        return Arrays.stream(values())
                .filter(s -> s.jobFields.contains(jobField))
                .toList();
    }
}
