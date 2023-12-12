package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        this.name = validateName(name);
        this.position = 0;
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
        if (inputValue.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        return inputValue;
    }

    private boolean isPossibleMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
}
