package christmas.domain;

import java.time.DayOfWeek;
import java.util.Map;

public class PreOrder {

    private final int day;
    private final Order order;
    EventCalendar eventCalendar;

    public PreOrder(final int day, final Order order) {
        this.day = day;
        this.order = order;
        this.eventCalendar = new EventCalendar();
    }

    public int getTotalCountOfFoodType(final FoodType foodType) {
        return order.countFoodType(foodType);
    }

    public int getTotalOrderPrice() {
        return order.sumTotalPrice();
    }

    public int getChristmasDday() {
        return eventCalendar.getDDayChristmas(day);
    }

    public DayOfWeek getDayofWeek() {
        return eventCalendar.getDayOfWeek(day);
    }

    public boolean hasStar() {
        return eventCalendar.hasStar(day);
    }

    public boolean isContainDayRange(final int startDay, final int endDay) {
        return startDay <= day && day <= endDay;
    }

    public Map<Menu, Integer> getOrederMap() {
        return order.orderToMap();
    }
}
