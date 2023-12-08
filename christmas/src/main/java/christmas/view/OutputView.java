package christmas.view;

import static christmas.constant.exception.ViewMessage.OUTPUT_AMOUNT_FORMAT;
import static christmas.constant.exception.ViewMessage.OUTPUT_BENEFIT_BADGE_HEADER;
import static christmas.constant.exception.ViewMessage.OUTPUT_BENEFIT_DETAILS_HEADER;
import static christmas.constant.exception.ViewMessage.OUTPUT_BENEFIT_EXPECTED_AMOUNT_HEADER;
import static christmas.constant.exception.ViewMessage.OUTPUT_BENEFIT_GIVEAWAY_HEADER;
import static christmas.constant.exception.ViewMessage.OUTPUT_BENEFIT_ORDER_HEADER;
import static christmas.constant.exception.ViewMessage.OUTPUT_BENEFIT_PREVIEW_HEADER;
import static christmas.constant.exception.ViewMessage.OUTPUT_BENEFIT_TOT_DISCOUNT_AMOUNT_HEADER;
import static christmas.constant.exception.ViewMessage.OUTPUT_BENEFIT_TOT_ORDER_AMOUNT_HEADER;
import static christmas.constant.exception.ViewMessage.OUTPUT_EMPTY;
import static christmas.constant.exception.ViewMessage.OUTPUT_GIVEAWAY_FORMAT;
import static christmas.constant.exception.ViewMessage.OUTPUT_NOTIFICATION_1;
import static christmas.constant.exception.ViewMessage.OUTPUT_NOTIFICATION_2;
import static christmas.constant.exception.ViewMessage.OUTPUT_NOTIFICATION_3;
import static christmas.constant.exception.ViewMessage.OUTPUT_NOTIFICATION_4;
import static christmas.constant.exception.ViewMessage.OUTPUT_ORDER_FORMAT;
import static christmas.constant.exception.ViewMessage.OUTPUT_WELCOME;

import christmas.domain.Menu;
import christmas.dto.ReservationConfirm;
import christmas.service.event.BadgeEvent;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void printNotification() {
        System.out.println(OUTPUT_WELCOME.getMessage());
        System.out.println(OUTPUT_NOTIFICATION_1.getMessage());
        System.out.println(OUTPUT_NOTIFICATION_2.getMessage());
        System.out.println(OUTPUT_NOTIFICATION_3.getMessage());
        System.out.println(OUTPUT_NOTIFICATION_4.getMessage());
    }

    public void printReservationConfirm(ReservationConfirm reservationConfirm) {
        System.out.println(OUTPUT_BENEFIT_PREVIEW_HEADER.getMessage());
        System.out.println();

        printOrderedMenus(reservationConfirm.order());
        printTotalOrderAmount(reservationConfirm.totDiscountAmount());
        printGiveaways(reservationConfirm.giveAway());
        System.out.println();
        printDiscountDetails(reservationConfirm.discountDetails());
        System.out.println();
        printDiscountAmount(reservationConfirm.totDiscountAmount());
        printExpectedAmount(reservationConfirm.expectedAmount());
        printBadge(reservationConfirm.badge());
    }

    private void printOrderedMenus(Map<Menu, Integer> order) {
        System.out.println(OUTPUT_BENEFIT_ORDER_HEADER.getMessage());
        order.forEach((food, count) -> {
            System.out.println(String.format(OUTPUT_ORDER_FORMAT.getMessage(), food.getName(), count));
        });
        System.out.println();
    }

    private void printTotalOrderAmount(int totOrderAmount) {
        System.out.println(OUTPUT_BENEFIT_TOT_ORDER_AMOUNT_HEADER.getMessage());
        System.out.println(String.format(OUTPUT_AMOUNT_FORMAT.getMessage(), totOrderAmount));
    }

    private void printGiveaways(List<String> givenAway) {
        System.out.println(OUTPUT_BENEFIT_GIVEAWAY_HEADER.getMessage());
        if (givenAway.isEmpty()) {
            System.out.println(OUTPUT_EMPTY.getMessage());
            return;
        }
        givenAway.forEach(
                (giveAway) -> System.out.println(String.format(OUTPUT_GIVEAWAY_FORMAT.getMessage(), giveAway)));
    }

    private void printDiscountDetails(Map<String, Integer> discountDetails) {
        System.out.println(OUTPUT_BENEFIT_DETAILS_HEADER.getMessage());
        if (discountDetails.isEmpty()) {
            System.out.println(OUTPUT_EMPTY.getMessage());
            return;
        }
        discountDetails.forEach((discountName, amount) ->
                System.out.println(String.format(OUTPUT_ORDER_FORMAT.getMessage(), discountName, amount)
                ));
    }

    private void printDiscountAmount(int totDiscountAmount) {
        System.out.println(OUTPUT_BENEFIT_TOT_DISCOUNT_AMOUNT_HEADER.getMessage());
        System.out.println(String.format(OUTPUT_AMOUNT_FORMAT.getMessage(), totDiscountAmount));
    }

    private void printExpectedAmount(int expectedAmount) {
        System.out.println(OUTPUT_BENEFIT_EXPECTED_AMOUNT_HEADER.getMessage());
        System.out.println(String.format(OUTPUT_AMOUNT_FORMAT.getMessage(), expectedAmount));
    }

    private void printBadge(BadgeEvent badge) {
        System.out.println(OUTPUT_BENEFIT_BADGE_HEADER.getMessage());
        System.out.println(badge.getName());
    }
}
