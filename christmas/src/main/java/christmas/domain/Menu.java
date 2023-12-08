package christmas.domain;

import christmas.constant.exception.ErrorMessage;
import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Menu {
    BUTTON_MUSHROOM_SOUP(FoodType.APPETIZER, "양송이수프", 6_000),
    TAPAS(FoodType.APPETIZER, "타파스", 5_500),
    CAESAR_SALAD(FoodType.APPETIZER, "시저샐러드", 8_000),

    T_BONE_STEAK(FoodType.MAIN, "티본스테이크", 55_000),
    BARBECUE_RIBS(FoodType.MAIN, "바비큐립", 54_000),
    SEAFOOD_PASTA(FoodType.MAIN, "해산물파스타", 35_000),
    CHRISTMAS_PASTA(FoodType.MAIN, "크리스마스파스타", 25_000),

    CHOCO_CAKE(FoodType.DESERT, "초코케이크", 15_000),
    ICE_CREAM(FoodType.DESERT, "아이스크림", 5_000),

    ZERO_COKE(FoodType.DRINK, "제로콜라", 3_000),
    RED_WINE(FoodType.DRINK, "레드와인", 60_000),
    CHAMPAGNE(FoodType.DRINK, "샴페인", 25_000);


    private FoodType type;
    private String name;
    private int price;

    Menu(final FoodType type, final String name, final int price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public static Menu getMenuByName(final String name) {
        return Arrays.stream(values()).filter(food -> name.equals(food.getName()))
                .findAny().orElseThrow(() -> new NoSuchElementException(ErrorMessage.MENU_ERROR_MESSAGE.getMessage()));
    }

    public FoodType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
