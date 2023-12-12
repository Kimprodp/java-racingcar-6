package racingcar.controller;

import racingcar.view.constants.Message;

public class InputProcessor {

    private static final String COMMA = ",";

    public static String[] validateText(String inputValue) {
        validateEmpty(inputValue);
        return validateSeparate(inputValue);
    }

    public static int validateNumber(String inputValue) {
        validateEmpty(inputValue);
        return validateInteger(inputValue);
    }

    private static void validateEmpty(String inputValue) {
        if (inputValue.isEmpty()) {
            throw  new IllegalArgumentException(Message.ERROR_EMPTY.getErrorMessage());
        }
    }

    private static String[] validateSeparate(String inputValue) {
        if (!inputValue.contains(COMMA)) {
            throw new IllegalArgumentException(Message.ERROR_NOT_SEPARATE.getErrorMessage());
        }
        return inputValue.split(COMMA);
    }

    private static int validateInteger(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_NOT_INTEGER.getErrorMessage());
        }
    }
}
