package lotto;

public enum staticWord {
    ERROR("[ERROR]",0),FIFTH("5",5000),
    FOURTH("4",50000),THIRD("3",1500000),
    SECOND("2",30000000),FIRST("1",2000000000);

    private final String value;
    private final int value2;
    staticWord(String value, int value2) {
        this.value = value;
        this.value2 = value2;
    }

    public String getValue() {
        return value;
    }

    public int getValue2() {
        return value2;
    }
}
