package christmas.service.event;

import christmas.domain.Menu;
import christmas.domain.PreOrder;
import christmas.domain.Reservation;

public class GiveAwayEvent {

    private static final String DETAIL_NAME = "증정 이벤트";
    private static final Menu GIFT = Menu.CHAMPAGNE;
    private static final int BASE_PRICE = 120_000;


    public void receiveGiveAwayIfConfirm(PreOrder preOrder, Reservation reservation) {
        if (confirmGiveAwayEvent(preOrder, reservation)) {
            reservation.addDiscountType(DETAIL_NAME, -GIFT.getPrice());
            reservation.addGiveAway(GIFT.getName());
        }
    }

    private boolean confirmGiveAwayEvent(PreOrder preOrder, Reservation reservation) {
        return preOrder.getTotalOrderPrice() >= BASE_PRICE;
    }
}
