package lotto.domain.entity;

import static lotto.common.Constants.DECIMAL_POINT;
import static lotto.common.Constants.HUNDRED_RATE;
import static lotto.common.Constants.LOTTO_PRICE;

import java.util.Map;

public class WiningTypeCount {

    private final Map<WiningType, Integer> winingCountMap;

    public WiningTypeCount(final Map<WiningType, Integer> winingCountMap) {
        this.winingCountMap = winingCountMap;
    }

    public double calculateRateOfReturn(final int lottoCount) {
        final long amount = sumAmount();
        double money = lottoCount * LOTTO_PRICE;
        double rateOfReturn = Math.round((amount / money) * DECIMAL_POINT) / DECIMAL_POINT * HUNDRED_RATE;
        return rateOfReturn;
    }

    private long sumAmount() {
        long totAmount = 0;
        for (WiningType winingType : winingCountMap.keySet()) {
            totAmount += winingCountMap.getOrDefault(winingType, 0) * winingType.getAmount();
        }
        return totAmount;
    }

    public int getWiningCount(WiningType winingType) {
        return winingCountMap.get(winingType);
    }
}
