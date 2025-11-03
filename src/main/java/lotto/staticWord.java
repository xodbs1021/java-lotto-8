package lotto;

public enum staticWord {
    // value: 등수 ("5" = 5등), value2: 상금, matchCount: 실제 일치 개수
    ERROR("[ERROR]", 0, 0),
    FIFTH("5", 5000, 3),        // 5등, 5000원, 3개 일치
    FOURTH("4", 50000, 4),      // 4등, 50000원, 4개 일치
    THIRD("3", 1500000, 5),     // 3등, 150만원, 5개 일치
    SECOND("2", 30000000, 5),   // 2등, 3000만원, 5개 일치 (보너스볼 포함)
    FIRST("1", 2000000000, 6);  // 1등, 20억, 6개 일치

    private final String value;
    private final int value2;
    private final int matchCount; // ⭐ 새로 추가: 실제 일치 개수

    staticWord(String value, int value2, int matchCount) {
        this.value = value;
        this.value2 = value2;
        this.matchCount = matchCount;
    }

    public String getValue() {
        return value;
    }

    public int getValue2() {
        return value2;
    }

    public int getMatchCount() { // ⭐ 새로 추가된 Getter
        return matchCount;
    }
}