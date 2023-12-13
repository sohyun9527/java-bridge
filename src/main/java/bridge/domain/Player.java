package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private boolean clear = false;

    private int tryCount = 1;
    private final List<Move> moves = new ArrayList<>(); // 성공한 움직인 커멘드 저장


    public void resetMoves() {
        moves.clear();
        tryCount++;
    }

    public void clearGame() {
        clear = true;
    }

    public String getLastMove() {
        return moves.get(moves.size() - 1).getCommand();
    }

    public void move(Move move) {
        moves.add(move);
    }

    public boolean isClear() {
        return clear;
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<Move> getMoves() {
        return moves;
    }
}
