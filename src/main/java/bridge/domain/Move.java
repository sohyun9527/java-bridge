package bridge.domain;

import java.util.Arrays;

public enum Move {
    UP("U", 1),
    DOWN("D", 0);

    private final String command;
    private final int number;

    Move(String command, int number) {
        this.command = command;
        this.number = number;
    }

    public static String findByNumber(int number) {
        return Arrays.stream(values())
                .filter(move -> move.number == number)
                .findFirst()
                .map(Move::getCommand)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 번호입니다."));
    }

    public static Move of(String moveCommand) {
        return Arrays.stream(values())
                .filter(command -> command.command.equals(moveCommand))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] U(위), D(아래)로만 움직일 수 있습니다."));
    }

    public String getCommand() {
        return command;
    }
}
