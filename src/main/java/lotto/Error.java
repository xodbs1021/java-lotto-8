package lotto;

public enum Error {
    ERROR("[ERROR]");

    private final String value;
    Error(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
