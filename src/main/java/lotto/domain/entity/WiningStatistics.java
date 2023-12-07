package lotto.domain.entity;

import java.util.Map;

public record WiningStatistics(
        Map<Rank, Integer> matchCount,
        double rateOfReturn
) {
}
