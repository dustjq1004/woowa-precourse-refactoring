package christmas.dto;

import christmas.domain.Menu;
import christmas.service.event.BadgeEvent;
import java.util.List;
import java.util.Map;

public record ReservationConfirm(
        Map<Menu, Integer> order,
        int totOrderAmount,
        int totDiscountAmount,
        int expectedAmount,
        Map<String, Integer> discountDetails,
        List<String> giveAway,
        BadgeEvent badge
) {

}
