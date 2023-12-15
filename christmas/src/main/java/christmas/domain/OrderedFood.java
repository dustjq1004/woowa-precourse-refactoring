package christmas.domain;

import christmas.constant.exception.ErrorMessage;

public class OrderedFood {

    private static final int COUNT_ZERO = 0;

    private final Menu menu;
    private final int count;

    public OrderedFood(final Menu menu, final int count) {
        validation(menu, count);
        this.menu = menu;
        this.count = count;
    }

    private void validation(Menu menu, int count) {
        if (count <= COUNT_ZERO) {
            throw new IllegalArgumentException(ErrorMessage.MENU_ERROR_MESSAGE.getMessage());
        }
    }

    public boolean compareTo(final Menu menu) {
        return this.menu == menu;
    }

    public boolean compareTo(final FoodType foodType) {
        return this.menu.getType() == foodType;
    }

    public int getCount() {
        return count;
    }

    public Menu getMenu() {
        return menu;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderedFood)) {
            return false;
        }
        OrderedFood other = (OrderedFood) obj;
        return other.compareTo(menu);
    }

    @Override
    public int hashCode() {
        int result = 31 * Integer.hashCode(menu.hashCode());
        return result;
    }

    public int calculatePrice() {
        return menu.getPrice() * count;
    }
}
