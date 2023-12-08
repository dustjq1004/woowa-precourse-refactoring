package christmas.service.policy;

import christmas.domain.PreOrder;
import christmas.domain.Reservation;

public interface DiscountPolicy {
    public Reservation calculatePrice(PreOrder preOrder, Reservation reservation);
}
