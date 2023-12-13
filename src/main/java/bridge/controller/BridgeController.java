package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.domain.Bridge;
import bridge.domain.Condition;
import bridge.domain.Move;
import bridge.domain.Player;
import bridge.util.ReadUntilValid;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        Bridge bridge = generateBridge();
        Player player = new Player();
        BridgeGame bridgeGame = new BridgeGame(bridge, player);
        gameStart(bridgeGame, player);
    }

    private void gameStart(BridgeGame bridgeGame, Player player) {
        while (true) {
            Move move = Move.of(inputView.readMoving());
            if (bridgeGame.move(move)) { // 최종 결과
                outputView.printMap(player.getMoves(), player.isClear());
                return;
            }
            if (!bridgeGame.isValidMove()) { // 틀렸다 -> 재시작 여부 묻기
                Condition condition = Condition.of(inputView.readGameCommand());
                if (condition.getCommand().equals("Q")) {
                    outputView.printResult(player);
                    return;
                }
                player.resetMoves();
            }
        }
    }

    private Bridge generateBridge() {
        return ReadUntilValid.readUntilValidInput(() -> {
            int bridgeSize = inputView.readBridgeSize();
            List<String> answer = bridgeMaker.makeBridge(bridgeSize);
            return new Bridge(answer);
        });
    }

}
