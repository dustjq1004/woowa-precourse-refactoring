package lotto.domain;

import java.util.List;
import lotto.domain.entity.Bonus;
import lotto.domain.entity.Lotto;
import lotto.domain.entity.MatchCount;
import lotto.domain.entity.Rank;
import lotto.domain.entity.WiningNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WiningNumbersTest {

    @Test
    @DisplayName("5등에 당첨된 로또가 1개다.")
    void countWiningTest1() {
        // given
        WiningNumbers winingNumbers = new WiningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Bonus(7));
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 11, 12, 13)),
                new Lotto(List.of(1, 9, 10, 11, 12, 13)),
                new Lotto(List.of(1, 2, 10, 11, 12, 13))
        );

        // when
        MatchCount matchCount = winingNumbers.countWining(lottos);
        int winingCount = matchCount.getMatchCount().get(Rank.FIVE);

        // then
        Assertions.assertEquals(winingCount, 1);
    }

    @Test
    @DisplayName("5등에 당첨된 로또가 2개다.")
    void countWiningTest2() {
        // given
        WiningNumbers winingNumbers = new WiningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Bonus(7));
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 11, 12, 13)),
                new Lotto(List.of(4, 5, 6, 12, 13, 14)),
                new Lotto(List.of(1, 9, 10, 11, 12, 13)),
                new Lotto(List.of(1, 2, 10, 11, 12, 13))
        );

        // when
        MatchCount matchCount = winingNumbers.countWining(lottos);
        int winingCount = matchCount.getMatchCount().get(Rank.FIVE);

        // then
        Assertions.assertEquals(winingCount, 2);
    }

    @Test
    @DisplayName("1등에 당첨된 로또가 1개다.")
    void countWiningTest3() {
        // given
        WiningNumbers winingNumbers = new WiningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Bonus(7));
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(4, 5, 6, 12, 13, 14)),
                new Lotto(List.of(1, 9, 10, 11, 12, 13)),
                new Lotto(List.of(1, 2, 10, 11, 12, 13))
        );

        // when
        MatchCount matchCount = winingNumbers.countWining(lottos);
        int winingCount = matchCount.getMatchCount().get(Rank.ONE);

        // then
        Assertions.assertEquals(winingCount, 1);
    }

    @Test
    @DisplayName("2등에 당첨된 로또가 10개다.")
    void countWiningTest4() {
        // given
        WiningNumbers winingNumbers = new WiningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Bonus(7));
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(2, 3, 4, 5, 6, 7)),
                new Lotto(List.of(1, 3, 4, 5, 6, 7)),
                new Lotto(List.of(1, 2, 4, 5, 6, 7)),
                new Lotto(List.of(1, 2, 3, 5, 6, 7)),
                new Lotto(List.of(1, 2, 3, 4, 6, 7))
        );

        // when
        MatchCount matchCount = winingNumbers.countWining(lottos);
        int winingCount = matchCount.getMatchCount().get(Rank.TWO);

        // then
        Assertions.assertEquals(winingCount, 10);
    }
}