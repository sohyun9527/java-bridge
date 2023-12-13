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
        startGame(bridgeGame, player);
    }


    private void startGame(BridgeGame bridgeGame, Player player) {

        ReadUntilValid.readUntilValid(() -> {
            boolean isGameRunning = true;
            while (isGameRunning) {
                Move move = inputView.readMoving();
                if (makeMoveAndCheckResult(bridgeGame, player, move)) {
                    isGameRunning = false;
                }
                if (!bridgeGame.isValidMove()) {
                    isGameRunning = !handleInvalidMove(player);
                }
            }
        });
    }

    private boolean makeMoveAndCheckResult(BridgeGame bridgeGame, Player player, Move move) {
        if (bridgeGame.move(move)) { // allClear
            outputView.printMap(player.getMoves(), player.isClear());
            return true;
        }
        outputView.printMap(player.getMoves(), player.isClear());
        return false;
    }

    private boolean handleInvalidMove(Player player) {
        ReadUntilValid.readUntilValidInput(() -> {
            Condition condition = inputView.readGameCommand();
            if (condition == Condition.QUIT) {
                outputView.printResult(player);
                return false;
            }
            player.resetMoves();
            return true;
        });
        return true;
    }

    private Bridge generateBridge() {
        return ReadUntilValid.readUntilValidInput(() -> {
            int bridgeSize = inputView.readBridgeSize();
            List<String> answer = bridgeMaker.makeBridge(bridgeSize);
            for (String s : answer) {
                System.out.printf("%s", s);
            }
            return new Bridge(answer);
        });
    }

}
