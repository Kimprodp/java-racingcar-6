package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingHistory;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.constants.Message;

public class Controller {

    public void run() {
        List<Car> cars = setCar();
        RacingGame racingGame = setRacingGame(cars);
        racingGame.startRacing();
        showRacingResult(racingGame);
        printWinner(racingGame);
    }

    private List<Car> setCar() {
        OutputView.printMessage(Message.INPUT_CAR_NAME);
        return ExceptionHandler.retryInput(this::registerCar);
    }

    private List<Car>  registerCar() {
        String[] names = ExceptionHandler.retryInput(this::inputCarName);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private String[] inputCarName() {
        return InputProcessor.validateText(InputView.readLine());
    }

    private RacingGame setRacingGame(List<Car> cars) {
        OutputView.printMessage(Message.INPUT_RACING_COUNT);
        return ExceptionHandler.retryInput(() -> registerRacingGame(cars));
    }

    private RacingGame registerRacingGame(List<Car> cars) {
        int numberOfRaces = ExceptionHandler.retryInput(this::inputNumberOfRaces);
        return new RacingGame(cars, numberOfRaces);
    }

    private int inputNumberOfRaces() {
        return InputProcessor.validateNumber(InputView.readLine());
    }

    private void showRacingResult(RacingGame racingGame) {
        OutputView.printMessage(Message.OUTPUT_RACING_RESULT);
        printRoundResult(racingGame.getRacingHistory());
    }

    private void printRoundResult(RacingHistory racingHistory) {
        for (Integer round : racingHistory.getHistory().keySet()) {
            OutputView.printRoundResult(racingHistory.getRoundResult(round));
        }
    }

    private void printWinner(RacingGame racingGame) {
        OutputView.printWinner(racingGame.getWinnerName());
    }
}
