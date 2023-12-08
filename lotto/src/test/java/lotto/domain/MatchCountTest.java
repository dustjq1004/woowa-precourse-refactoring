package lotto.domain;

import java.util.List;
import lotto.domain.entity.Bonus;
import lotto.domain.entity.Lotto;
import lotto.domain.entity.MatchCount;
import lotto.domain.entity.WiningNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MatchCountTest {

    @Test
    void 수익률이_백프로다() {
        //given
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16))
        );
        Lotto wining = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        Bonus bonus = new Bonus(44);

        // when
        WiningNumbers winingNumbers = new WiningNumbers(wining, bonus);
        MatchCount matchCount = winingNumbers.countWining(lottos);

        // then
        Assertions.assertEquals(matchCount.calculateRateOfReturn(lottos.size()), 100);
    }

    @Test
    void 수익률이_오백프로다() {
        //given
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Lotto wining = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        Bonus bonus = new Bonus(44);

        // when
        WiningNumbers winingNumbers = new WiningNumbers(wining, bonus);
        MatchCount matchCount = winingNumbers.countWining(lottos);

        // then
        Assertions.assertEquals(matchCount.calculateRateOfReturn(lottos.size()), 500);
    }
}