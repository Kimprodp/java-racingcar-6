package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.List;
import racingcar.view.constants.Message;

public class RacingGame {

    private List<Car> cars;
    private int numberOfRaces;
    private RacingHistory racingHistory;

    public RacingGame(List<Car> cars, int numberOfRaces) {
        this.cars = cars;
        this.numberOfRaces = validateNumberOfRaces(numberOfRaces);
        this.racingHistory = new RacingHistory();
    }

    public void startRacing() {
        for (int i = 1; i <= numberOfRaces; i++) {
            racingHistory.addHistory(i, runRound());
        }
    }

    public RacingHistory getRacingHistory() {
        return racingHistory;
    }

    private int validateNumberOfRaces(int numberOfRaces) {
        if (numberOfRaces < 1) {
            throw new IllegalArgumentException(Message.ERROR_RACING_COUNT_ZERO.getErrorMessage());
        }
        return numberOfRaces;
    }

    private LinkedHashMap<String, Integer> runRound() {
        LinkedHashMap<String, Integer> roundResult = new LinkedHashMap<>();
        for (Car car : cars) {
            car.moveForward();
            roundResult.put(car.getName(), car.getPosition());
        }
        return roundResult;
    }
}
