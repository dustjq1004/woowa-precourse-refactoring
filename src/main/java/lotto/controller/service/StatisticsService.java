package lotto.controller.service;

import lotto.domain.entity.WiningStatistics;
import lotto.domain.entity.WiningTypeCount;

public class StatisticsService {

    public WiningStatistics calculateWiningStatistics(WiningTypeCount winingTypeCount, int lottoCount) {
        double rateOfReturn = winingTypeCount.calculateRateOfReturn(lottoCount);
        return new WiningStatistics(winingTypeCount, rateOfReturn);
    }
}
