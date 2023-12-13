package bridge.view;

import bridge.domain.Move;
import bridge.domain.Player;
import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    //게임 성공 여부: 성공
    //총 시도한 횟수: 2
    private static final String START_MESSAGE = "다리건너기 게임을 시작합니다.";
    private static final String CLEAR_RESULT = "게임 성공 여부: ";
    private static final String TRY_COUNT = "총 시도한 횟수: ";
    private static final String RESULT = "최종 게임 결과";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<Move> moves, boolean isClear) {
        StringJoiner upBridge = new StringJoiner(" | ", "[ ", " ]");
        StringJoiner downBridge = new StringJoiner(" | ", "[ ", " ]");

        int lastIndex = moves.size() - 1;

        for (int i = 0; i < moves.size(); i++) {
            Move move = moves.get(i);
            boolean isLastMove = i == lastIndex;

            upBridge.add(getBridgeCharacter(move, Move.UP, !isClear && isLastMove));
            downBridge.add(getBridgeCharacter(move, Move.DOWN, !isClear && isLastMove));
        }

        System.out.println(upBridge);
        System.out.println(downBridge);
    }

    private String getBridgeCharacter(Move move, Move expectedMove, boolean replaceLastO) {
        String result = " ";
        if (move == expectedMove) {
            result = "O";
            if (replaceLastO) {
                result = "X";
            }
        }
        return result;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Player player) {
        System.out.println(RESULT);
        printMap(player.getMoves(), player.isClear());
        printClearResult(player.isClear());
        printTryCount(player.getTryCount());
    }

    public void printClearResult(boolean isSuccess) {
        StringBuilder sb = new StringBuilder(CLEAR_RESULT);
        if (isSuccess) {
            sb.append("성공");
        }
        sb.append("실패");
        System.out.println(sb);
    }

    public void printTryCount(int count) {
        System.out.println(TRY_COUNT + count);
    }
}
