package christmas.view;

import static christmas.constant.exception.ViewMessage.INPUT_ORDER_MENU;
import static christmas.constant.exception.ViewMessage.INPUT_RESERVATION_DATE;

import camp.nextstep.edu.missionutils.Console;
import christmas.validation.ViewValidation;

public class InputView {

    public String readDate() {
        System.out.println(INPUT_RESERVATION_DATE.getMessage());
        String date = Console.readLine();
        ViewValidation.validateReservationDate(date);
        return date;
    }

    public String readOrder() {
        System.out.println(INPUT_ORDER_MENU.getMessage());
        String order = Console.readLine();
        return order;
    }
}
