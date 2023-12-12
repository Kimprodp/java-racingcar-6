package racingcar.domain;

import java.util.LinkedHashMap;

public class RacingHistory {

    private class CarPosition {

        private LinkedHashMap<String, Integer> roundResult;

        public CarPosition(LinkedHashMap<String, Integer> forwardResult) {
            this.roundResult = forwardResult;
        }

        public LinkedHashMap<String, Integer> getForwardResult() {
            return roundResult;
        }
    }

    private LinkedHashMap<Integer, CarPosition> history;
    private CarPosition carPosition;

    public RacingHistory() {
        this.history = new LinkedHashMap<>();
    }

    public void addHistory(int round, LinkedHashMap<String, Integer> roundResult) {
        this.carPosition = new CarPosition(roundResult);
        history.put(round, carPosition);
    }

    public LinkedHashMap<Integer, CarPosition> getHistory() {
        return history;
    }

    public LinkedHashMap<String, Integer> getRoundResult(int round) {
        return history.get(round).getForwardResult();
    }
}
