package christmas.service.policy;

import christmas.domain.PreOrder;
import christmas.domain.Reservation;

public class SpecialPolicy implements DiscountPolicy {

    private static final String DETAIL_NAME = "특별 할인";
    private int startDay = 1;
    private int endDay = 31;
    private int baseDiscountPrice = 1000;

    @Override
    public Reservation calculatePrice(PreOrder preOrder, Reservation reservation) {
        if (preOrder.hasStar() && preOrder.isContainDayRange(startDay, endDay)) {
            reservation.addDiscountType(DETAIL_NAME, -baseDiscountPrice);
        }
        return reservation;
    }
}
