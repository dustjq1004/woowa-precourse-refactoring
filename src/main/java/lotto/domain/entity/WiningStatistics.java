package lotto.domain.entity;

import java.util.Map;

public record WiningStatistics(
        Map<WiningType, Integer> matchCount,
        double rateOfReturn
) {
}
