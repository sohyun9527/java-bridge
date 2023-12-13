package bridge.domain;

public enum PlayerMove {
    RIGHT("O"),
    WRONG("X");

    private final String result;

    PlayerMove(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
