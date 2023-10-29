package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.service.Exception;
import racingcar.view.OutputView;

public class GameController {

    private Exception exception;
    private RacingGame racingGame;

    public GameController() {
        exception = new Exception();
        racingGame = new RacingGame();
    }

    /*
    private final CarService carService = new CarService();
    private final RacingGameService game = new RacingGameService();
     */

    public void play() {
        String carName = InputView.inputCarName();
        String testedCarName = exception.checkCarName(carName);
        racingGame.setCarList(testedCarName);

        String raceCount = InputView.inputRaceCount();
        String testedRaceCount = exception.checkRaceCount(raceCount);
        racingGame.setRaceCount(testedRaceCount);
        racingGame.startRace();


        //startRace();
        //showWinner();
    }

    public static void showRaceResult(String carName, int position) {
        OutputView.printCarPosition(carName, position);
    }

    public static void markRaceEnd() {
        OutputView.markRaceEnd();
    }

    /*
    public void startGame() {
        if (racingGame.startRace()) {

        }
     */

    /*
    private void inputCarName() {
        ExceptionService.checkCarName(InputView.inputCarName());
    }


    private void setCar() {
        Car.carList = new ArrayList<>();
        for (String name : Exception.carNames) {
            Car.carList.add(new Car(name));
        }
    }
     */

    /*
    private void setRaceCount() {
        game.setRaceCount(ExceptionService.checkRaceCount(InputView.inputRaceCount()));
    }

    private void startRace() {
        OutputView.printRaceResultMessage();
        game.startRaceCount();
    }

    private void showWinner() {
        game.selectWinner();
        String winnerList = String.join(",", game.getWinnerList());
        OutputView.printWinner(winnerList);
    }
     */
}
