package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.common.StringUtils;
import lotto.domain.entity.LottoMoney;
import lotto.validation.ViewValidation;

public class InputView {

    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String NEW_LINE = "\n";
    private static final String DELIMITER_COMMA = ",";

    public LottoMoney printMoney() {
        System.out.println(INPUT_MONEY);
        String money = Console.readLine();
        ViewValidation.validateNumeric(money);
        return new LottoMoney(Integer.parseInt(money));
    }

    public List<Integer> printWiningNumbers() {
        System.out.println(INPUT_WINING_NUMBERS);
        String numbers = Console.readLine();
        ViewValidation.validateCommaNumeric(numbers);
        return StringUtils.asListByDelimiter(numbers, DELIMITER_COMMA);
    }

    public int printBonusNumber() {
        System.out.println(NEW_LINE + INPUT_BONUS_NUMBER);
        String number = Console.readLine();
        ViewValidation.validateNumeric(number);
        return Integer.parseInt(number);
    }
}
