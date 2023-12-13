package bridge.view;

import bridge.domain.Condition;
import bridge.domain.Move;
import bridge.validation.InputValidation;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String REQUEST_SIZE = "다리의 길이를 입력해주세요.";
    private static final String REQUEST_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String REQUEST_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(REQUEST_SIZE);
        String input = getUserInput();
        InputValidation.validateBridgeLength(input);
        return Integer.parseInt(input);
    }

    private String getUserInput() {
        return Console.readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Move readMoving() {
        System.out.println(REQUEST_MOVE);
        String input = getUserInput();
        return Move.of(input);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public Condition readGameCommand() {
        System.out.println(REQUEST_COMMAND);
        String input = getUserInput();
        return Condition.of(input);
    }
}
