package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.constants.Message;

public class Car {

    private static final int NAME_MAX_SIZE = 5;
    private static final int POSITION_DEFAULT_VALUE = 0;
    private static final int RANDOM_NUMBER_MIN_SIZE = 0;
    private static final int RANDOM_NUMBER_MAX_SIZE = 9;
    private static final int MOVE_FORWARD_MIN_NUMBER = 4;


    private String name;
    private int position;

    public Car(String name) {
        this.name = validateName(name);
        this.position = POSITION_DEFAULT_VALUE;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        if (isPossibleMoveForward()) {
            position++;
        }
    }

    private String validateName(String inputValue) {
        if (inputValue.length() > NAME_MAX_SIZE) {
            throw new IllegalArgumentException(Message.ERROR_CAR_NAME_SIZE_OVER.getErrorMessage());
        }
        return inputValue;
    }

    private boolean isPossibleMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN_SIZE, RANDOM_NUMBER_MAX_SIZE);
        return randomNumber >= MOVE_FORWARD_MIN_NUMBER;
    }
}
