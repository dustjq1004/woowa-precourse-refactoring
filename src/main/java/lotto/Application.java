package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoProgram;
import lotto.controller.service.LottoCreateService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoProgram lottoProgram = new LottoProgram(new InputView(), new OutputView()
                , new LottoCreateService());
        lottoProgram.run();
        Console.close();
    }
}
