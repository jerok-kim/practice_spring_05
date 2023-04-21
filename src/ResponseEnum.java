public enum ResponseEnum {
    SUCCESS(1),
    FAIL(-1);

    private final int value;

    ResponseEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
