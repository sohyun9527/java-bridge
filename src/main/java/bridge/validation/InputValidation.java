package bridge.validation;

public class InputValidation {
    private static final int MINIMUM_SIZE = 3;
    private static final int MAXIMUM_SIZE = 20;

    public static void validateBridgeLength(String input) {
        validateIsEmpty(input);
        validateOnlyDigit(input);
        validateSize(input);
    }

    public static void validateIsEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 아무것도 입력하지 않았습니다.");
        }
    }

    public static void validateOnlyDigit(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자만 입력해주세요.");
        }
    }

    public static void validateSize(String input) {
        int size = Integer.parseInt(input);
        if (size < MINIMUM_SIZE || size > MAXIMUM_SIZE) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3 ~ 20 사이로 입력해주세요.");
        }
    }
}
