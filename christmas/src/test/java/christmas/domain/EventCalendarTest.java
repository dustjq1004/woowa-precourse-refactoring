package christmas.domain;

import java.time.DayOfWeek;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class EventCalendarTest {

    private static EventCalendar eventCalendar;

    @BeforeAll
    static void eventCalendarInit() {
        eventCalendar = new EventCalendar();
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 14, 21, 28})
    @DisplayName("입력된 날짜는 목요일이다.")
    void isThursdayByDayTest(int day) {
        // when & then
        Assertions.assertThat(eventCalendar.getDayOfWeek(day)).isEqualTo(DayOfWeek.THURSDAY);
    }

    @Test
    @DisplayName("List.of(3, 10, 17, 24, 25, 31)은 별을 가지고 있다.")
    void hasStarTest() {
        // given
        List<Integer> hasStar = List.of(3, 10, 17, 24, 25, 31);

        // when & then
        hasStar.forEach((day) -> {
            Assertions.assertThat(eventCalendar.hasStar(day)).isTrue();
        });
    }

    @Test
    @DisplayName("List.of(3, 10, 17, 24, 25, 31)은 별을 가지고 있지 않다.")
    void hasNotStarTest() {
        // given
        List<Integer> hasStar = List.of(4, 11, 16, 23, 26, 30);
        EventCalendar eventCalendar = new EventCalendar();

        // when & then
        hasStar.forEach((day) -> {
            Assertions.assertThat(eventCalendar.hasStar(day)).isFalse();
        });
    }

    @Test
    @DisplayName("입력된 날짜의 크리스마스 디데이는 24이다.")
    void calculateChristmasDDay() {
        // given
        int day = 1;

        // when
        int dDayChristmas = eventCalendar.getDDayChristmas(day);

        // then
        Assertions.assertThat(dDayChristmas).isEqualTo(25);
    }
}