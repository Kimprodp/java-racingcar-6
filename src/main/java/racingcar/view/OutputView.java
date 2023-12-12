package racingcar.view;

import java.util.LinkedHashMap;
import java.util.List;
import racingcar.view.constants.Message;

public class OutputView {

    public static void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printRoundResult(LinkedHashMap<String, Integer> roundResult) {
        for (String car : roundResult.keySet()) {
            System.out.print(String.format(Message.OUTPUT_ROUND_RESULT.getMessage(), car));
            for (int i = 0; i < roundResult.get(car); i++) {
                System.out.print(Message.OUTPUT_FORWARD_RESULT.getMessage());
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printWinner(List<String> winner) {
        System.out.print(Message.OUTPUT_RACING_WINNER.getMessage());
        System.out.print(String.join(", ", winner));
    }
}
