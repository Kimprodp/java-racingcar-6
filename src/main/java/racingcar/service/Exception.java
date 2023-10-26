package racingcar.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exception {

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String BLANK = " ";
    public static List<String> carNames;
    public static void checkCarName(String inputValue) throws IllegalArgumentException {
        checkEmpty(inputValue);

        carNames = Arrays.asList(inputValue.split(","));
        for (String name : carNames) {
            checkNoName(name);
            checkblank(name);
            checkLength(name);
        }

        checkSameName();
    }

    public static void checkRaceCount(String inputValue) {

    }

    private static void checkEmpty(String inputValue) {
        if (inputValue.isEmpty()) {
            throw new IllegalArgumentException("잘못된 값 입력 : 자동차 이름을 입력해주세요.");
        }
    }

    private static void checkNoName(String inputValue) {
        if (inputValue.isEmpty() || inputValue.equals(BLANK)) {
            throw new IllegalArgumentException("잘못된 값 입력 : 입력되지 않은 자동차 이름이 있습니다.");
        }
    }

    private static void checkblank(String inputValue) {
        if (inputValue.contains(BLANK)) {
            throw new IllegalArgumentException("잘못된 값 입력 : 자동차 이름에는 공백이 들어갈 수 없습니다.");
        }
    }

    private static void checkLength(String inputValue) {
        if (inputValue.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("잘못된 값 입력 : 자동차 이름은 5자 이내로 입력해주세요");
        }
    }

    private static void checkSameName() {
        Set<String> setTypeCarNames = new HashSet<>(carNames);
        if (carNames.size() != setTypeCarNames.size()) {
            throw new IllegalArgumentException("잘못된 값 입력 : 중복된 자동차 이름이 있습니다.");
        }
    }

    //private static void check
}