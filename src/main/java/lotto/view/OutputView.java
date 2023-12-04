package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.entity.Lotto;
import lotto.domain.entity.WiningStatistics;
import lotto.domain.entity.WiningType;

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
        Map<WiningType, Integer> matchCount = statistics.matchCount();
        for (WiningType winingType : WiningType.getWiningCountEmptyMap().keySet()) {
            addWiningCountString(winingType, stringBuffer, matchCount);
        }
        stringBuffer.append(String.format(OUTPUT_RATE_OF_RETUN, statistics.rateOfReturn()));
        System.out.println(stringBuffer);
    }

    private void addWiningCountString(WiningType winingType, StringBuffer stringBuffer
            , Map<WiningType, Integer> matchCount) {
        if (winingType == WiningType.ZERO) {
            return;
        }

        stringBuffer.append(String.format(OUTPUT_WINING_CORRECT_COUNT, winingType.getCorrectCount()));
        if (winingType.hasBonus()) {
            stringBuffer.append(OUTPUT_HAS_BONUS);
        }
        stringBuffer.append(String.format(OUTPUT_WINING_AMOUNT, winingType.getAmount()));
        stringBuffer.append(OUTPUT_BAR);
        stringBuffer.append(String.format(OUTPUT_WINING_COUNT, matchCount.get(winingType)));
        stringBuffer.append(NEW_LINE);
    }
}
