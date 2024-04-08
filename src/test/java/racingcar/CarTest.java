package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {

    @Test
    void 자동차이름_5자초과() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Car("abcdef"));
        assertThat(e.getMessage()).isEqualTo("자동차 이름 길이 초과 (최대 5자)");
    }

    @Test
    void 자동차_제자리() throws Exception {
        Car car = new Car("abc");
        car.move(1);
        assertThat(car.checkMaxLocation(1)).isEqualTo(1);
    }

    @Test
    void 자동차_move() throws Exception {
        Car car = new Car("abc");
        car.move(5);
        assertThat(car.checkMaxLocation(5)).isEqualTo(5);
    }

    @Test
    void 이름_split() {
        String inputNames = "pobi,crong,honux";
        String[] names = inputNames.split(",");
        assertThat(names).containsExactly("pobi","crong","honux");
    }

}
