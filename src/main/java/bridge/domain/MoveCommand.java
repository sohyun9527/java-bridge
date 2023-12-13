package bridge.domain;

import java.util.Arrays;

public enum MoveCommand {
    UP("U", 1),
    DOWN("D", 0);

    private final String command;
    private final int number;

    MoveCommand(String command, int number) {
        this.command = command;
        this.number = number;
    }

    public static String findByNumber(int number) {
        return Arrays.stream(values())
                .filter(moveCommand -> moveCommand.number == number)
                .findFirst()
                .map(MoveCommand::getCommand)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 번호입니다."));
    }

    public String getCommand() {
        return command;
    }
}
