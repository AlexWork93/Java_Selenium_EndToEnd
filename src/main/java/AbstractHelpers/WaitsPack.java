package AbstractHelpers;

public enum WaitsPack {
    ONE_SECOND(1),
    TWO_SECOND(2),
    FIVE_SECOND(5),
    TEN_SECOND(10),
    TWENTY_SECOND(20);

    private final int timeout;
    WaitsPack(int timeout) {
        this.timeout = timeout;
    }

    public int getTimeout() {
        return timeout;
    }
}
