package christmas.service.policy;

import christmas.domain.PreOrder;
import christmas.domain.Reservation;

public class ChristmasDDayPolicy implements DiscountPolicy {

    private static final String DETAIL_NAME = "크리스마스 디데이 할인";
    private int startDay = 1;
    private int endDay = 25;
    private int baseDiscountPrice = 1000;
    private int dayPrice = 100;

    @Override
    public Reservation calculatePrice(PreOrder preOrder, Reservation reservation) {
        if (preOrder.isContainDayRange(startDay, endDay)) {
            int discountPrice = calculateDiscountPrice(preOrder.getChristmasDday());
            reservation.addDiscountType(DETAIL_NAME, -discountPrice);
        }
        return reservation;
    }

    private int calculateDiscountPrice(final int dDay) {
        return baseDiscountPrice + dayPrice * (endDay - dDay);
    }
}
