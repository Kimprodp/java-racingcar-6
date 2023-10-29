package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차위치_초기값0 () {
        Car car = new Car("testCar");
        assertThat(0).isEqualTo(car.getPosition());
    }

    @Test
    void 랜덤값4이상_자동차전진증가 () {
        Car car = new Car("testCar");
        int randomNumber = 4;
        car.setPosition(randomNumber);

        assertThat(1).isEqualTo(car.getPosition());
    }
}