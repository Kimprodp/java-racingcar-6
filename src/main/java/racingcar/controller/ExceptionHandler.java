package racingcar.controller;

import java.util.function.Supplier;
import racingcar.view.OutputView;

public class ExceptionHandler {

    public static <T> T retryInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (Exception e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}
