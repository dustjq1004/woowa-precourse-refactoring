package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.controller.service.LottoCreateService;
import lotto.controller.service.LottoMatchService;
import lotto.controller.service.StatisticsService;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoMoney;
import lotto.model.WiningNumbers;
import lotto.model.WiningStatistics;
import lotto.model.WiningTypeCount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoProgram {
    InputView inputView;
    OutputView outputView;
    LottoCreateService lottoCreateService;

    public LottoProgram(InputView inputView, OutputView outputView, LottoCreateService lottoCreateService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoCreateService = lottoCreateService;
    }

    public void start() {
        LottoMoney money = inputView.printMoney();
        List<Lotto> lottos = purchaseLottoNumbers(money);
        drawLottery(lottos);
    }

    private List<Lotto> purchaseLottoNumbers(LottoMoney money) {
        List<Lotto> lottos = lottoCreateService.createRandomLottoNumbers(money);
        outputView.printBuyingLotto(lottos);
        return lottos;
    }

    private void drawLottery(List<Lotto> lottoTicket) {
        Lotto numbers = inputView.printWiningNumbers();
        Bonus bonusNumber = inputView.printBonusNumber();
        WiningNumbers winingNumbers = new WiningNumbers(numbers, bonusNumber);
        result(lottoTicket, winingNumbers);
    }

    private void result(List<Lotto> lottoTicket, WiningNumbers winingNumbers) {
        LottoMatchService lottoMatchService = new LottoMatchService();
        StatisticsService statisticsService = new StatisticsService();
        WiningTypeCount winingTypeCount = lottoMatchService.matchLottoTicket(winingNumbers, lottoTicket);
        WiningStatistics winingStatistics =
                statisticsService.calculateWiningStatistics(winingTypeCount, lottoTicket.size());
        outputView.printWiningStatistics(winingStatistics);
    }
}
