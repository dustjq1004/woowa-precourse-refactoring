package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.entity.Lotto;
import lotto.domain.entity.Rank;
import lotto.domain.entity.WiningStatistics;

public class OutputView {

    private static final String OUTPUT_THREE_BAR = "---\n";
    private static final String OUTPUT_BAR = "- ";
    private static final String NEW_LINE = "\n";
    private static final String OUTPUT_BUYING_LOTTO = "8개를 구매했습니다.\n";
    private static final String OUTPUT_WINING_HEADER = "당첨 통계\n";
    private static final String OUTPUT_WINING_CORRECT_COUNT = "%d개 일치";
    private static final String OUTPUT_HAS_BONUS = ", 보너스 볼 일치";
    private static final String OUTPUT_WINING_AMOUNT = " (%,d원) ";
    private static final String OUTPUT_WINING_COUNT = "%d개";
    private static final String OUTPUT_RATE_OF_RETUN = "총 수익률은 %s%%입니다.";

    public void printBuyingLotto(List<Lotto> lottos) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(NEW_LINE);
        stringBuffer.append(OUTPUT_BUYING_LOTTO);
        lottos.forEach(lotto -> stringBuffer.append(lotto + NEW_LINE));
        System.out.println(stringBuffer);
    }

    public void printWiningStatistics(WiningStatistics statistics) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(NEW_LINE);
        stringBuffer.append(OUTPUT_WINING_HEADER);
        stringBuffer.append(OUTPUT_THREE_BAR);
        Map<Rank, Integer> matchCount = statistics.matchCount();
        for (Rank rank : Rank.getWiningCountEmptyMap().keySet()) {
            addWiningCountString(rank, stringBuffer, matchCount);
        }
        stringBuffer.append(String.format(OUTPUT_RATE_OF_RETUN, statistics.rateOfReturn()));
        System.out.println(stringBuffer);
    }

    private void addWiningCountString(Rank rank, StringBuffer stringBuffer
            , Map<Rank, Integer> matchCount) {
        if (rank == Rank.ZERO) {
            return;
        }

        stringBuffer.append(String.format(OUTPUT_WINING_CORRECT_COUNT, rank.getCorrectCount()));
        if (rank.hasBonus()) {
            stringBuffer.append(OUTPUT_HAS_BONUS);
        }
        stringBuffer.append(String.format(OUTPUT_WINING_AMOUNT, rank.getAmount()));
        stringBuffer.append(OUTPUT_BAR);
        stringBuffer.append(String.format(OUTPUT_WINING_COUNT, matchCount.get(rank)));
        stringBuffer.append(NEW_LINE);
    }
}
