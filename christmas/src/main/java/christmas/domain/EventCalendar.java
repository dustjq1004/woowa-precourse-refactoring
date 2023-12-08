package christmas.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class EventCalendar {

    private static final List hasStarDays = List.of(3, 10, 17, 24, 25, 31);
    private static final int EVENT_YEAR = 2023;
    private static final Month EVENT_MONTH = Month.DECEMBER;
    private static final int CHRISTMAS_DAY = 25;

    public DayOfWeek getDayOfWeek(final int day) {
        return LocalDate.of(EVENT_YEAR, EVENT_MONTH, day).getDayOfWeek();
    }

    public boolean hasStar(final int day) {
        return hasStarDays.contains(day);
    }

    public int getDDayChristmas(final int day) {
        final int plus = 1;
        return (int) ChronoUnit.DAYS.between(LocalDate.of(EVENT_YEAR, EVENT_MONTH, day)
                , LocalDate.of(EVENT_YEAR, EVENT_MONTH, CHRISTMAS_DAY)) + plus;
    }
}
