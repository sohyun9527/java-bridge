package bridge.util;

import java.util.function.Supplier;

public class ReadUntilValid {

    public static <T> T readUntilValidInput(Supplier<T> inputFunction) {
        while (true) {
            try {
                return inputFunction.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void readUntilValid(Runnable inputFunction) {
        while (true) {
            try {
                inputFunction.run();
                return;  // Return if the operation completes successfully
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
