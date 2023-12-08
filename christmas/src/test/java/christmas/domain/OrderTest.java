package christmas.domain;

import christmas.utils.OrderGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    @DisplayName("주문한 메뉴에는 메인 메뉴인 음식이 3개 있다.")
    void ThreeCountMainMenu() {
        String name = "티본스테이크-3,초코케이크-1";
        Order order = OrderGenerator.generateOrder(name);

        // when & then
        Assertions.assertThat(order.countFoodType(FoodType.MAIN)).isEqualTo(3);
    }

    @Test
    @DisplayName("주문한 메뉴에는 음료 메뉴인 음식이 1개 있다.")
    void OneCountDrinkMenu() {
        String name = "티본스테이크-3,샴페인-1";
        Order order = OrderGenerator.generateOrder(name);

        // when & then
        Assertions.assertThat(order.countFoodType(FoodType.DRINK)).isEqualTo(1);
    }

}