package christmas.service.policy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.PreOrder;
import christmas.domain.Reservation;
import christmas.utils.OrderGenerator;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DayOfWeekPolicyTest {

    @Test
    @DisplayName("평일 예약을 하여 디저트 할인을 받는다.")
    void getDiscountDessertMenu() {
        Map<Menu, Integer> foods = Map.of(Menu.CHOCO_CAKE, 2, Menu.CHRISTMAS_PASTA, 1);
        String client = "초코케이크-2,크리스마스파스타-1";
        Order order = OrderGenerator.generateOrder(client);
        PreOrder preOrder = new PreOrder(18, order);
        Reservation reservation = new Reservation();
        DiscountPolicy policy = new DayOfWeekPolicy();

        // when
        policy.calculatePrice(preOrder, reservation);
        int 평일_할인 = reservation.getDiscountDetailsBy("평일 할인");

        // then
        assertEquals(평일_할인, -4046);
    }

    @Test
    @DisplayName("주말 예약을 하여 메인 메뉴 할인을 받는다.")
    void getDiscountMainMenu() {
        Map<Menu, Integer> foods = Map.of(Menu.CHOCO_CAKE, 2, Menu.CHRISTMAS_PASTA, 1);
        String client = "초코케이크-2,크리스마스파스타-1";
        Order order = OrderGenerator.generateOrder(client);
        PreOrder preOrder = new PreOrder(23, order);
        Reservation reservation = new Reservation();
        DiscountPolicy policy = new DayOfWeekPolicy();

        // when
        policy.calculatePrice(preOrder, reservation);
        int 주말_할인 = reservation.getDiscountDetailsBy("주말 할인");

        // then
        assertEquals(주말_할인, -2023);
    }
}