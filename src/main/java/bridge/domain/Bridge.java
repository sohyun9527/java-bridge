package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> answer;

    public Bridge(List<String> answer) {
        this.answer = answer;
    }

    public boolean isAllClear(Player player) {
        List<Move> playerMoves = player.getMoves();
        if (isValidMoves(playerMoves) && isEndOfBridge(playerMoves.size())) {
            player.clearGame();
            return true;
        }
        return false;
    }

    public boolean isValidMoves(List<Move> moves) {
        for (Move move : moves) {
            String command = move.getCommand();
            if (isWrongMove(command)) {
                return false;
            }
        }
        return true;
    }

    private boolean isWrongMove(String command) {
        for (String answerCommand : answer) {
            if (!command.equals(answerCommand)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEndOfBridge(int moveCount) {
        return answer.size() == moveCount;
    }
}
