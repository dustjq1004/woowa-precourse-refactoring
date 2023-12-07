package lotto.domain.entity;

import java.util.List;
import java.util.Map;

public class WiningNumbers {

    private final Lotto numbers;
    private final Bonus bonus;

    public WiningNumbers(final Lotto numbers, final Bonus bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public MatchCount countWining(List<Lotto> lottos) {
        Map<Rank, Integer> winingCountMap = Rank.getWiningCountEmptyMap();
        lottos.forEach(lotto -> {
            int correctCount = lotto.countCorrectNumbers(numbers);
            boolean hasBonus = bonus.compareNumber(lotto);
            Rank wining = Rank.getRankByLottoCount(correctCount, hasBonus);
            winingCountMap.computeIfPresent(wining, (key, count) -> ++count);
        });
        return new MatchCount(winingCountMap);
    }
}
