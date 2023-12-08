package christmas.domain;

import java.util.NoSuchElementException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuTest {

    @ParameterizedTest
    @ValueSource(strings = {"크리스마스파스타", "티본스테이크", "해산물파스타", "바비큐립"})
    @DisplayName("메뉴에서 이름으로 메인음식을 선택한다.")
    void getMenuByNameTest(String name) {
        Assertions.assertThat(Menu.getMenuByName(name).getType()).isEqualTo(FoodType.MAIN);
    }

    @ParameterizedTest
    @ValueSource(strings = {"바나나", "돈까스", "딸기라떼"})
    @DisplayName("메뉴에 없는 음식을 선택한다")
    void NoSelectedMenuExceptionTest(String name) {
        //when & then
        Assertions.assertThatThrownBy(() -> Menu.getMenuByName(name)).isInstanceOf(NoSuchElementException.class);
    }
}