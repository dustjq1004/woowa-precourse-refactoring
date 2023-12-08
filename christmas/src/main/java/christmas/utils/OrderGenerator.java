package christmas.utils;

import christmas.constant.exception.ErrorMessage;
import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.OrderedFood;
import java.util.ArrayList;
import java.util.List;

public class OrderGenerator {

    private static final String DELIMITER_COMMA = ",";
    private static final String DELIMITER_DASH = "-";

    public static Order generateOrder(final String target) {
        try {
            List<OrderedFood> order = new ArrayList<>();
            for (String orderedFood : target.split(DELIMITER_COMMA)) {
                String[] details = orderedFood.split(DELIMITER_DASH);
                Menu menu = Menu.getMenuByName(details[0]);
                int menuCount = Integer.parseInt(details[1]);
                order.add(new OrderedFood(menu, menuCount));
            }
            return new Order(order);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.MENU_ERROR_MESSAGE.getMessage());
        }
    }
}
