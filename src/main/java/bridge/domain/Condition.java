package bridge.domain;

import java.util.Arrays;

public enum Condition {
    RETRY("R"),
    QUIT("Q");

    private final String command;

    Condition(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static Condition of(String input) {
        return Arrays.stream(values())
                .filter(condition -> condition.command.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 재시작은 R, 종료는 Q입니다."));
    }
}
