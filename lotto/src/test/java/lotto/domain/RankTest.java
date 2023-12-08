package lotto.domain;

import java.util.Arrays;
import lotto.domain.entity.Lotto;
import lotto.domain.entity.Rank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @Test
    @DisplayName("1등에 담청됐다. 당첨 번호 1, 4, 15, 26, 30, 45 보너스 번호 : 33")
    void toWinOneWinningTypeTest() {
        //given
        Lotto winingNumbers = new Lotto(Arrays.asList(1, 4, 15, 26, 30, 45));
        int bonus = 33;
        Lotto lotto = new Lotto(Arrays.asList(1, 4, 15, 26, 30, 45));
        //when
        Rank rank = Rank.getRankByLottoCount(lotto.countCorrectNumbers(winingNumbers),
                lotto.containNumber(bonus));
        //then
        Assertions.assertEquals(rank, Rank.ONE);
    }

    @Test
    @DisplayName("2등에 담청됐다. 당첨 번호 1, 4, 15, 26, 30, 45 보너스 번호 : 33")
    void toWinTwoWinningTypeTest() {
        //given
        Lotto winingNumbers = new Lotto(Arrays.asList(1, 4, 15, 26, 30, 45));
        int bonus = 33;
        Lotto lotto = new Lotto(Arrays.asList(1, 4, 15, 26, 33, 45));
        //when
        Rank rank = Rank.getRankByLottoCount(lotto.countCorrectNumbers(winingNumbers),
                lotto.containNumber(bonus));
        //then
        Assertions.assertEquals(rank, Rank.TWO);
    }

    @Test
    @DisplayName("3등에 담청됐다. 당첨 번호 1, 4, 15, 26, 30, 45 보너스 번호 : 33")
    void toWinThreeWinningTypeTest() {
        //given
        Lotto winingNumbers = new Lotto(Arrays.asList(1, 4, 15, 26, 30, 45));
        int bonus = 33;
        Lotto lotto = new Lotto(Arrays.asList(1, 4, 15, 26, 30, 43));
        //when
        Rank rank = Rank.getRankByLottoCount(lotto.countCorrectNumbers(winingNumbers),
                lotto.containNumber(bonus));
        //then
        Assertions.assertEquals(rank, Rank.THREE);
    }

    @Test
    @DisplayName("4등에 담청됐다. 당첨 번호 1, 4, 15, 26, 30, 45 보너스 번호 : 33")
    void toWinFourWinningTypeTest() {
        //given
        Lotto winingNumbers = new Lotto(Arrays.asList(1, 4, 15, 26, 30, 45));
        int bonus = 33;
        Lotto lotto = new Lotto(Arrays.asList(1, 4, 15, 26, 41, 43));
        //when
        Rank rank = Rank.getRankByLottoCount(lotto.countCorrectNumbers(winingNumbers),
                lotto.containNumber(bonus));
        //then
        Assertions.assertEquals(rank, Rank.FOUR);
    }

    @Test
    @DisplayName("5등에 담청됐다. 당첨 번호 1, 4, 15, 26, 30, 45 보너스 번호 : 33")
    void toWinFiveWinningTypeTest() {
        //given
        Lotto winingNumbers = new Lotto(Arrays.asList(1, 4, 15, 26, 30, 45));
        int bonus = 33;
        Lotto lotto = new Lotto(Arrays.asList(1, 4, 15, 22, 41, 43));
        //when
        Rank rank = Rank.getRankByLottoCount(lotto.countCorrectNumbers(winingNumbers),
                lotto.containNumber(bonus));
        //then
        Assertions.assertEquals(rank, Rank.FIVE);
    }

}
