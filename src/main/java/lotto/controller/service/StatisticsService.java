package lotto.controller.service;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WiningNumbers;
import lotto.model.WiningStatistics;
import lotto.model.WiningTypeCount;

public class StatisticsService {

    public WiningStatistics calculateWiningStatistics(WiningTypeCount winingTypeCount, int lottoCount) {
        double rateOfReturn = winingTypeCount.calculateRateOfReturn(lottoCount);
        return new WiningStatistics(winingTypeCount, rateOfReturn);
    }
}
