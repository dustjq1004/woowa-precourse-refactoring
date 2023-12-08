package lotto.controller.service;

import lotto.domain.entity.MatchCount;
import lotto.domain.entity.WiningStatistics;

public class StatisticsService {

    public WiningStatistics calculateWiningStatistics(MatchCount matchCount, int lottoCount) {
        double rateOfReturn = matchCount.calculateRateOfReturn(lottoCount);
        return new WiningStatistics(matchCount.getMatchCount(), rateOfReturn);
    }
}
