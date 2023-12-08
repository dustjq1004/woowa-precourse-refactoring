package christmas.utils;

import christmas.domain.Menu;
import christmas.domain.Order;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringConverterTest {

    @Test
    @DisplayName("주문 문자열을 Map으로 변환한다. 주문에는 티본스테이크가 있다.")
    void StringToOrderMap() {
        String client = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Order order = OrderGenerator.generateOrder(client);
        Assertions.assertThat(order.orderToMap()).isIn(
                Map.of(Menu.T_BONE_STEAK, 1,
                        Menu.BARBECUE_RIBS, 1,
                        Menu.CHOCO_CAKE, 2,
                        Menu.ZERO_COKE, 1)
        );
    }
}