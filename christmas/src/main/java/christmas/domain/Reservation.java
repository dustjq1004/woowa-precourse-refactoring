package christmas.domain;

import christmas.service.event.BadgeEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reservation {

    private static final int PRICE_ZERO = 0;

    private final Map<String, Integer> discountDetails;
    private final List<String> giveAways;

    public Reservation() {
        this.discountDetails = new HashMap<>();
        this.giveAways = new ArrayList<>();
    }

    public void addDiscountType(final String name, final int price) {
        discountDetails.put(name, price);
    }

    public int getTotalDiscountedPrice() {
        return discountDetails.values()
                .stream()
                .mapToInt((price) -> price)
                .sum();
    }

    public BadgeEvent getBadge() {
        return BadgeEvent.getEventBadgeIfPrice(getTotalDiscountedPrice());
    }

    public int getDiscountDetailsBy(final String discountName) {
        final Integer price = discountDetails.get(discountName);
        if (price == null) {
            return PRICE_ZERO;
        }
        return price.intValue();
    }

    public void addGiveAway(final String name) {
        giveAways.add(name);
    }

    public Map<String, Integer> getDiscountDetails() {
        return discountDetails;
    }

    public List<String> getGiveAways() {
        return giveAways;
    }
}