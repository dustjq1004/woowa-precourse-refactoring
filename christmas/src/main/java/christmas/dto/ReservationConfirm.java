package christmas.dto;

import christmas.domain.Menu;
import christmas.service.event.BadgeEvent;
import java.util.Collections;
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

    public static class Builder {
        private final Map<Menu, Integer> order;
        private final BadgeEvent badge;

        private int totOrderAmount = 0;
        private int totDiscountAmount = 0;
        private int expectedAmount = 0;
        private Map<String, Integer> discountDetails = Collections.emptyMap();
        private List<String> giveAway = Collections.emptyList();

        public Builder(Map<Menu, Integer> order, BadgeEvent badge) {
            this.order = order;
            this.badge = badge;
        }

        public Builder totOrderAmount(int val) {
            this.totOrderAmount = val;
            return this;
        }

        public Builder totDiscountAmount(int val) {
            this.totDiscountAmount = val;
            return this;
        }

        public Builder expectedAmount(int val) {
            this.expectedAmount = val;
            return this;
        }

        public Builder discountDetails(Map<String, Integer> val) {
            this.discountDetails = val;
            return this;
        }

        public Builder giveAway(List<String> val) {
            this.giveAway = val;
            return this;
        }

        public ReservationConfirm build() {
            return new ReservationConfirm(order,
                        totOrderAmount,
                        totDiscountAmount,
                        expectedAmount,
                        discountDetails,
                        giveAway,
                        badge
                    );
        }
    }
}
