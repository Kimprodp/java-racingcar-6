package racingcar.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.constants.Message;

public class RacingGame {

    private List<Car> cars;
    private int numberOfRaces;
    private RacingHistory racingHistory;
    private List<Car> winner;

    public RacingGame(List<Car> cars, int numberOfRaces) {
        this.cars = cars;
        this.numberOfRaces = validateNumberOfRaces(numberOfRaces);
        this.racingHistory = new RacingHistory();
        this.winner = new ArrayList<>();
    }

    public void startRacing() {
        for (int i = 1; i <= numberOfRaces; i++) {
            racingHistory.addHistory(i, runRound());
        }
        confirmWinner();
    }

    public RacingHistory getRacingHistory() {
        return racingHistory;
    }

    public List<String> getWinnerName() {
        return winner.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
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

    private void confirmWinner() {
        int highPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        winner.addAll(cars.stream()
                .filter(car -> car.getPosition() == highPosition)
                .collect(Collectors.toList()));
    }
}
