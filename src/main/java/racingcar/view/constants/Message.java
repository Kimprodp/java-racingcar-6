package racingcar.view.constants;

public enum Message {

    /* Input */
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_RACING_COUNT("시도할 회수는 몇회인가요?"),

    /* Output */
    OUTPUT_RACING_RESULT("\n" + "실행 결과"),
    OUTPUT_RACING_WINNER("\n" + "최종 우승자 : %s, %s"),
    OUTPUT_ROUND_RESULT("%s : "),
    OUTPUT_FORWARD_RESULT("-"),

    /* Error */
    ERROR_EMPTY("입력값이 없습니다."),
    ERROR_NOT_SEPARATE("쉼표(,)를 기준으로 구분하여 입력해주세요."),
    ERROR_NOT_INTEGER("숫자만 입력 가능합니다."),
    ERROR_CAR_NAME_SIZE_OVER("자동차 이름은 5자 이하만 가능합니다."),
    ERROR_RACING_COUNT_ZERO("시도할 횟수는 한 번 이상으로 입력해주세요");


    public static final String ERROR_PREFIX = "[ERROR] ";
    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorMessage() {
        return ERROR_PREFIX + message;
    }
}
