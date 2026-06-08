package com.bamdoliro.gilajabi.domain.school.entity;

import java.util.Arrays;
import java.util.List;

public enum MeisterSchool {

    // 서울
    SUDO_ELECTRIC("MS001", "수도전기공업고", "서울", "에너지", "https://sudo.sen.hs.kr", true, 180, "2.17:1",
            List.of("전기 기사", "전력설비 기술자", "배전 기술자", "계측 기기 기술자"),
            "전기/전자", "과학"),
    MIRIM_GIRLS_IT("MS002", "미림마이스터고등학교", "서울", "뉴미디어콘텐츠", "https://www.e-mirim.hs.kr", true, 102, null,
            List.of("UI/UX 디자이너", "웹 개발자", "영상 편집자", "앱 개발자", "그래픽 디자이너"),
            "IT", "미디어", "디자인"),
    SEOUL_ROBOT("MS003", "서울로봇고", "서울", "로봇", "https://srobot.sen.hs.kr", true, 120, null,
            List.of("로봇 엔지니어", "자동화 설비 기술자", "PLC 프로그래머", "로봇 유지보수 기술자"),
            "로봇", "기계", "전기/전자"),
    SEOUL_URBAN_TECH("MS004", "서울도시과학기술고", "서울", "해외건설·플랜트", "https://sust.sen.hs.kr", true, 120, null,
            List.of("건설 기술자", "토목 기술자", "플랜트 기술자", "해외 건설 현장 기술자"),
            "기계"),

    // 부산
    BUSAN_AUTO("MS005", "부산자동차고", "부산", "자동차산업", "https://automotive.hs.kr", true, 96, "1.25:1",
            List.of("자동차 정비사", "자동차 생산 기술자", "자동차 부품 기술자", "차량 검사원"),
            "기계"),
    BUSAN_MACHINE("MS006", "부산기계공업고", "부산", "기계", "https://www.bmt.hs.kr", true, 240, "1.16:1",
            List.of("기계 기술자", "생산 기술자", "CNC 기계 조작원", "용접 기술자"),
            "기계"),
    BUSAN_MARITIME("MS007", "부산해사고", "부산", "해양", "https://maritime.hs.kr", true, 128, null,
            List.of("항해사", "기관사", "해양 기술자", "선박 운항 기술자"),
            "기계"),
    BUSAN_SW("MS008", "부산소프트웨어마이스터고", "부산", "소프트웨어", "https://bssm.hs.kr", true, 64, "1.84:1",
            List.of("소프트웨어 개발자", "앱 개발자", "서버 개발자", "데이터 분석가"),
            "IT"),

    // 대구
    GYEONGBUK_MACHINE("MS009", "경북기계공업고", "대구", "기계·메카트로닉스", "https://gbgigong.dge.hs.kr", true, 120, null,
            List.of("기계 기술자", "생산 기술자", "CNC 기계 조작원", "자동차 부품 기술자"),
            "기계"),
    DAEGU_IL_MEISTER("MS010", "대구일마이스터고", "대구", "자동차", "https://dgmeister.dge.hs.kr", true, 120, null,
            List.of("자동차 생산 기술자", "자동차 부품 기술자", "자동화 설비 기술자", "품질 관리원"),
            "기계"),
    DAEGU_SW("MS011", "대구소프트웨어마이스터고", "대구", "SW·SW융합", "https://www.dgsw.hs.kr", true, 72, null,
            List.of("소프트웨어 개발자", "앱 개발자", "데이터 분석가", "IT 시스템 엔지니어"),
            "IT"),
    DAEGU_AGRI("MS012", "대구농업마이스터고", "대구", "도시형 첨단농업경영", "https://www.dma.dge.hs.kr", true, 60, null,
            List.of("스마트팜 운영자", "농업 기술자", "원예 기술자", "농산물 유통 관리자"),
            "농업"),

    // 인천
    INCHEON_ELECTRONIC("MS013", "인천전자마이스터고", "인천", "전자·통신", "https://intec.icehs.kr", true, 120, null,
            List.of("전자 기술자", "반도체 공정 기술자", "전기전자 생산 기술자", "전자 설비 기술자"),
            "전기/전자"),
    INCHEON_MARITIME("MS014", "인천해사고", "인천", "해양", "https://inm.icehs.kr", true, 120, null,
            List.of("항해사", "기관사", "항만 운영원", "선박 기술자"),
            "기계"),

    // 광주
    GWANGJU_AUTO("MS015", "광주자동화설비공업고", "광주", "자동화설비", "https://gat.gen.hs.kr", true, 72, null,
            List.of("자동화 설비 기술자", "생산 자동화 엔지니어", "PLC 프로그래머", "설비 유지보수 기술자"),
            "기계"),
    GWANGJU_SW("MS016", "광주소프트웨어마이스터고", "광주", "소프트웨어", "https://gsm.gen.hs.kr", true, 72, "1.7:1",
            List.of("소프트웨어 개발자", "앱 개발자", "데이터 분석가", "IT 시스템 엔지니어"),
            "IT"),

    // 대전
    DONG_A_MEISTER("MS017", "동아마이스터고", "대전", "전자·기계", "https://dongahs.djsch.kr", true, 160, null,
            List.of("전자 기술자", "기계 기술자", "전자 설비 기술자", "생산 기술자"),
            "전기/전자", "기계"),
    DAEDEOK_SW("MS018", "대덕소프트웨어마이스터고", "대전", "소프트웨어", "https://dsmhs.djsch.kr", true, 64, null,
            List.of("소프트웨어 개발자", "임베디드 시스템 개발자", "사이버 보안 전문가", "IT 시스템 엔지니어"),
            "IT"),

    // 울산
    ULSAN_MEISTER("MS019", "울산마이스터고", "울산", "기계·자동화", "https://umhs.meistergo.co.kr", true, 120, null,
            List.of("기계 기술자", "용접 기술자", "생산 기술자", "플랜트 기술자"),
            "기계"),
    ULSAN_ENERGY("MS020", "울산에너지고", "울산", "에너지", "https://www.usenergy.hs.kr", true, 90, null,
            List.of("에너지 기술자", "정유 공정 기술자", "전기 기사", "설비 운영원"),
            "과학"),
    HYUNDAI_INDUSTRIAL("MS021", "현대공업고", "울산", "조선해양플랜트", "https://hit.hs.kr", true, 108, "2.96:1",
            List.of("조선 기술자", "용접 기술자", "선박 생산 기술자", "도장 기술자"),
            "기계"),

    // 경기
    SUWON_HITECH("MS022", "수원하이텍고", "경기", "메카트로닉스", "https://sht-h.goesw.kr", true, 144, null,
            List.of("기계 기술자", "생산 기술자", "정밀 기계 가공원", "설비 유지보수 기술자"),
            "기계"),
    PYEONGTAEK_MEISTER("MS023", "평택마이스터고", "경기", "자동차·기계", "https://ptmt-h.goept.kr", true, 160, null,
            List.of("자동차 생산 기술자", "자동차 부품 기술자", "배터리 기술자", "품질 관리원"),
            "기계"),
    GYEONGGI_GAME("MS024", "경기게임마이스터고", "경기", "게임 콘텐츠", "https://ggm-h.goeay.kr", true, 90, null,
            List.of("게임 개발자", "게임 클라이언트 개발자", "게임 서버 개발자", "QA 엔지니어"),
            "IT", "미디어", "디자인"),

    // 강원
    WONJU_MEDICAL("MS025", "원주의료고", "강원", "의료기기·바이오", "https://wonjumedi.gwe.hs.kr", true, 120, "1.13:1",
            List.of("의료기기 기술자", "의료 장비 기사", "의료기기 품질 관리사"),
            "의료/보건"),
    KOREA_ENERGY("MS026", "한국에너지마이스터고", "강원", "발전산업", "https://www.gvhs.kr", true, 60, "1.48:1",
            List.of("발전 기술자", "전기 기사", "보일러 기술자", "발전소 운영원"),
            "과학"),
    KOREA_FIRE("MS027", "한국소방마이스터고", "강원", "소방", "https://fire-meister.gwe.hs.kr", true, 60, "3.67:1",
            List.of("소방 기술자", "소방 설비 기사", "소방 시설 관리원", "방재 기술자"),
            "과학"),

    // 충북
    CHUNGBUK_SEMICONDUCTOR("MS028", "충북반도체고", "충북", "반도체장비", "https://school.cbe.go.kr/cbsemi-h", true, 90, "2.26:1",
            List.of("반도체 공정 기술자", "반도체 장비 기사", "반도체 품질 관리원", "웨이퍼 제조 기술자"),
            "전기/전자", "IT"),
    KOREA_BIO("MS029", "한국바이오마이스터고", "충북", "바이오", "https://kbmh.meistergo.co.kr", true, 56, null,
            List.of("바이오 기술자", "의약품 품질 관리원", "바이오 의약품 생산 기술자"),
            "과학", "의료/보건"),
    CHUNGBUK_ENERGY("MS030", "충북에너지고", "충북", "차세대전지", "https://www.cbenergy.hs.kr", true, 90, null,
            List.of("이차전지 기술자", "배터리 공정 기술자", "전지 소재 기술자", "배터리 품질 관리원"),
            "과학"),

    // 충남
    HAPDEOK_STEEL("MS031", "합덕제철고", "충남", "철강", "https://steel.meistergo.co.kr", true, 75, null,
            List.of("제철 기술자", "철강 기술자", "압연 기술자", "열처리 기술자"),
            "기계"),
    GONGJU_MEISTER("MS032", "공주마이스터고", "충남", "전기·전자", "https://gong.cnehs.kr", true, 64, null,
            List.of("전기 기사", "전자 기술자", "전기 설비 기술자", "PLC 기술자"),
            "전기/전자"),
    YEONMU_MEISTER("MS033", "연무마이스터고", "충남", "자동차부품제조", "https://ymth.meistergo.co.kr", true, 75, null,
            List.of("자동차 부품 기술자", "생산 기술자", "품질 관리원", "자동화 설비 기술자"),
            "기계"),
    KOREA_FOOD("MS034", "한국식품마이스터고", "충남", "식품", "https://kfm.cnehs.kr", true, 48, null,
            List.of("식품 기술자", "식품 품질 관리사", "식품 생산 기술자", "식품 가공 기술자"),
            "식품/조리", "식품/농업"),
    ASAN_SMART_FACTORY("MS035", "아산스마트팩토리마이스터고", "충남", "스마트공장", "https://asfm.cnehs.kr", true, 90, null,
            List.of("스마트팩토리 기술자", "자동화 엔지니어", "PLC/HMI 프로그래머", "산업용 IoT 기술자"),
            "기계", "IT"),

    // 전북
    GUNSAN_MACHINE("MS036", "군산기계공업고", "전북", "조선·기계", "https://school.jbedu.kr/kunsan-mh", true, 120, null,
            List.of("조선 기술자", "기계 기술자", "용접 기술자", "생산 기술자"),
            "기계"),
    JEONBUK_MACHINE("MS037", "전북기계공업고", "전북", "기계", "https://school.jbedu.kr/cmt", true, 208, null,
            List.of("기계 기술자", "생산 기술자", "CNC 기계 조작원", "설비 유지보수 기술자"),
            "기계"),
    KOREA_HORSE("MS038", "한국경마축산고", "전북", "말 산업", "https://school.jbedu.kr/horseman", true, 36, "1.19:1",
            List.of("기수", "조교사", "마필 관리사", "말 조련사", "승마 지도사"),
            "농업"),
    GIMJE_AGRI("MS039", "김제농생명마이스터고", "전북", "농생명자원생산·가공", "https://school.jbedu.kr/gmhsas", true, 90, null,
            List.of("스마트팜 운영 기술자", "농업 기술자", "농산물 가공 기술자"),
            "농업", "식품/농업"),

    // 전남
    KOREA_PORT_LOGISTICS("MS040", "한국항만물류고", "전남", "항만물류", "https://kpl.hs.jne.kr", true, 90, null,
            List.of("항만 운영 기술자", "물류 관리사", "항만 하역 기술자", "물류 시스템 운영원"),
            "경영"),
    JEONNAM_LIFE_SCIENCE("MS041", "전남생명과학고", "전남", "친환경농축산", "https://jn-life.hs.jne.kr", true, 90, null,
            List.of("농업 기술자", "축산 기술자", "농산물 가공 기술자"),
            "농업", "식품/농업"),
    YEOSU_PETROCHEMICAL("MS042", "여수석유화학고", "전남", "석유화학산업", "https://yeosu-th.hs.jne.kr", true, 96, null,
            List.of("석유화학 공정 기술자", "화학 기사", "품질 관리원", "설비 운영원"),
            "과학"),
    WANDO_FISHERIES("MS043", "완도수산고", "전남", "어업 및 수산물 가공", "https://wandosugo.hs.jne.kr", true, 72, null,
            List.of("어선 기술자", "수산 양식 기술자", "수산물 가공 기술자", "항해사"),
            "식품/농업"),

    // 경북
    GUMI_ELECTRONIC("MS044", "구미전자공업고", "경북", "전자", "https://gnet.hs.kr", true, 120, null,
            List.of("전자 기술자", "반도체 공정 기술자", "전자 생산 기술자", "전자 설비 기술자"),
            "전기/전자"),
    GEUMOH_INDUSTRIAL("MS045", "금오공업고", "경북", "기계·전자모바일", "https://school.gyo6.net/koths", true, 152, null,
            List.of("기계 기술자", "전자 기술자", "정밀 기계 가공원", "생산 기술자"),
            "기계", "전기/전자"),
    POSCO_INDUSTRIAL("MS046", "포항제철공업고", "경북", "철강", "https://school.gyo6.net/pocheoltechhs", true, 144, null,
            List.of("제철 기술자", "철강 공정 기술자", "압연 기술자", "제강 기술자"),
            "기계"),
    KOREA_NUCLEAR("MS047", "한국원자력마이스터고", "경북", "원자력발전설비", "https://knm.meistergo.co.kr", true, 60, "1.69:1",
            List.of("원자력 기술자", "방사선 관리 기사", "원자력 설비 기술자", "원자력 발전소 운영원"),
            "과학"),
    GYEONGBUK_BIO("MS048", "경북바이오마이스터고", "경북", "식품품질관리", "https://school.gyo6.net/gbm", true, 60, null,
            List.of("식품 기술자", "바이오 기술자", "식품 품질 관리사", "발효 기술자"),
            "식품/농업"),
    KOREA_INTL_TRADE("MS049", "한국국제통상마이스터고", "경북", "글로벌 비즈니스", "https://school.gyo6.net/gampohs", true, 60, null,
            List.of("무역 사무원", "해외 영업 담당자", "무역 통관 전문가", "글로벌 구매 담당자"),
            "경영"),
    KOREA_MARITIME("MS050", "한국해양마이스터고", "경북", "스마트해양수산", "https://school.gyo6.net/haema", true, 60, null,
            List.of("항해사", "기관사", "수산 기술자", "해양 기술자"),
            "기계"),

    // 경남
    GEOJE_INDUSTRIAL("MS051", "거제공업고", "경남", "조선", "https://geoje-th-h.gne.go.kr", true, 120, null,
            List.of("조선 기술자", "용접 기술자", "선박 생산 기술자", "배관 기술자"),
            "기계"),
    SAMCHEONPO_INDUSTRIAL("MS052", "삼천포공업고", "경남", "항공·조선", "https://samgong-h.gne.go.kr", true, 100, null,
            List.of("항공 기술자", "항공기 정비사", "조선 기술자", "항공 부품 생산 기술자"),
            "기계"),
    AIR_FORCE_AVIATION("MS053", "공군항공과학고", "경남", "항공기술", "https://www.airforce.mil.kr", true, 170, "남 4.1:1 / 여 3.4:1",
            List.of("항공 정비사", "항공 기술자", "항공우주 부품 기술자", "항공기 엔진 기술자"),
            "기계"),
    KOREA_NANO("MS054", "한국나노마이스터고", "경남", "나노융합", "https://nano.meistergo.co.kr", true, 90, null,
            List.of("나노 기술자", "반도체 공정 기술자", "나노 소재 연구원", "반도체 장비 기사"),
            "과학", "전기/전자");

    public final String id;
    public final String name;
    public final String location;
    public final String industryField;
    public final String website;
    public final boolean hasDormitory;
    public final int capacity;
    public final String competitionRate;
    public final List<String> mainJobs;
    public final List<String> jobFields;

    MeisterSchool(String id, String name, String location, String industryField,
                  String website, boolean hasDormitory, int capacity, String competitionRate,
                  List<String> mainJobs, String... jobFields) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.industryField = industryField;
        this.website = website;
        this.hasDormitory = hasDormitory;
        this.capacity = capacity;
        this.competitionRate = competitionRate;
        this.mainJobs = mainJobs;
        this.jobFields = Arrays.asList(jobFields);
    }

    public String getIcon() {
        if (jobFields.isEmpty()) return "🏫";
        return switch (jobFields.get(0)) {
            case "IT"       -> "💻";
            case "디자인"     -> "🎨";
            case "미디어"     -> "🎬";
            case "경영"      -> "📣";
            case "과학"      -> "🔬";
            case "기계"      -> "⚙️";
            case "전기/전자"  -> "⚡";
            case "식품/조리"  -> "🍳";
            case "농업",
                 "식품/농업" -> "🌱";
            case "의료/보건"  -> "🏥";
            case "로봇"      -> "🦾";
            default         -> "🏫";
        };
    }

    public static List<MeisterSchool> findByJobField(String jobField) {
        return Arrays.stream(values())
                .filter(s -> s.jobFields.contains(jobField))
                .toList();
    }
}
