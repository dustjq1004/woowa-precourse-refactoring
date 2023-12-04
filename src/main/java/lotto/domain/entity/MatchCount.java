package lotto.domain.entity;

import static lotto.common.Constants.DECIMAL_POINT;
import static lotto.common.Constants.HUNDRED_RATE;
import static lotto.common.Constants.LOTTO_PRICE;

import java.util.Collections;
import java.util.Map;

public class MatchCount {

    private final Map<WiningType, Integer> matchCount;

    public MatchCount(final Map<WiningType, Integer> matchCount) {
        this.matchCount = matchCount;
    }

    public double calculateRateOfReturn(final int lottoCount) {
        final long amount = sumAmount();
        double money = lottoCount * LOTTO_PRICE;
        double rateOfReturn = Math.round((amount / money) * DECIMAL_POINT) / DECIMAL_POINT * HUNDRED_RATE;
        return rateOfReturn;
    }

    private long sumAmount() {
        long totAmount = 0;
        for (WiningType winingType : matchCount.keySet()) {
            totAmount += matchCount.getOrDefault(winingType, 0) * winingType.getAmount();
        }
        return totAmount;
    }

    public Map<WiningType, Integer> getMatchCount() {
        return Collections.unmodifiableMap(matchCount);
    }
}
