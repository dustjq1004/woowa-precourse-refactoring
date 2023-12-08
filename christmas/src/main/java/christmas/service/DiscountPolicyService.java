package christmas.service;

import christmas.domain.PreOrder;
import christmas.domain.Reservation;
import christmas.service.event.GiveAwayEvent;
import christmas.service.policy.ChristmasDDayPolicy;
import christmas.service.policy.DayOfWeekPolicy;
import christmas.service.policy.DiscountPolicy;
import christmas.service.policy.SpecialPolicy;
import java.util.ArrayList;
import java.util.List;

public class DiscountPolicyService {

    private static final int APPLIED_MIN_AMOUNT = 10_000;

    private final List<DiscountPolicy> discountPolicies;
    private final GiveAwayEvent giveAwayEvent;

    public DiscountPolicyService() {
        List<DiscountPolicy> discountPolicies = new ArrayList<>();
        discountPolicies.add(new ChristmasDDayPolicy());
        discountPolicies.add(new DayOfWeekPolicy());
        discountPolicies.add(new SpecialPolicy());
        this.discountPolicies = discountPolicies;
        this.giveAwayEvent = new GiveAwayEvent();
    }

    public void calculateDiscountPriceByPolicy(PreOrder preOrder, Reservation reservation) {
        if (preOrder.getTotalOrderPrice() < APPLIED_MIN_AMOUNT) {
            return;
        }
        discountPolicies.forEach(discountPolicy -> {
            discountPolicy.calculatePrice(preOrder, reservation);
        });
        giveAwayEvent.receiveGiveAwayIfConfirm(preOrder, reservation);
    }
}
