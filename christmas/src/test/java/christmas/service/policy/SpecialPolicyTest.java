package christmas.service.policy;

import christmas.domain.PreOrder;
import christmas.domain.Reservation;
import christmas.utils.OrderGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialPolicyTest {

    @Test
    @DisplayName("날짜 정보에 따라서 특별 할인을 받는다.")
    void successSpecialDiscountTest() {
        // given
        DiscountPolicy discountPolicy = new SpecialPolicy();
        Reservation reservation = new Reservation();
        String client = "바비큐립-1,크리스마스파스타-1";
        PreOrder preOrder = new PreOrder(24, OrderGenerator.generateOrder(client));

        // when
        discountPolicy.calculatePrice(preOrder, reservation);
        int discountPrice = reservation.getDiscountDetailsBy("특별 할인");

        //then
        Assertions.assertThat(discountPrice).isEqualTo(-1000);
    }

    @Test
    @DisplayName("날짜 정보에 따라서 특별 할인을 받지 못한다.")
    void failSpecialDiscountTest() {
        // given
        DiscountPolicy discountPolicy = new SpecialPolicy();
        Reservation reservation = new Reservation();
        String client = "바비큐립-1,크리스마스파스타-1";
        PreOrder preOrder = new PreOrder(18, OrderGenerator.generateOrder(client));

        // when
        discountPolicy.calculatePrice(preOrder, reservation);
        int discountPrice = reservation.getDiscountDetailsBy("특별 할인");

        //then
        Assertions.assertThat(discountPrice).isEqualTo(0);
    }

}