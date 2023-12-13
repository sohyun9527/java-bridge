package bridge;

import bridge.domain.Bridge;
import bridge.domain.Condition;
import bridge.domain.Move;
import bridge.domain.Player;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final Player player;

    public BridgeGame(Bridge bridge, Player player) {
        this.bridge = bridge;
        this.player = player;
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(Move move) {
        player.move(move);
        return bridge.isAllClear(player);
    }

    public boolean isValidMove() {
        return bridge.isValidMoves(player.getMoves());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(Condition condition) {
        if (condition == Condition.RETRY) {
            player.resetMoves();
            return true;
        }
        return false;
    }
}
