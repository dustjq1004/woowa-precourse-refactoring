package lotto.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import lotto.controller.service.LottoCreateService;
import lotto.controller.service.LottoMatchService;
import lotto.controller.service.StatisticsService;
import lotto.model.Bonus;
import lotto.model.Lotto;
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

    public void run() {
        List<Lotto> lottoTicket = executeMethod(this::purchaseLottoNumbers);
        Lotto winingNumbers = executeMethod(this::getWiningNumbers);
        Bonus bonus = executeMethod(this::getBonusNumber);
        WiningTypeCount winingTypeCount = matchLotto(lottoTicket, new WiningNumbers(winingNumbers, bonus));
        result(winingTypeCount, lottoTicket.size());
    }

    private <T> T executeMethod(Supplier<Optional<T>> methodInput) {
        Optional<T> result;
        do {
            result = methodInput.get();
        } while (result.isEmpty());
        return result.get();
    }

    private Optional<List<Lotto>> purchaseLottoNumbers() {
        try {
            List<Lotto> lottoTicket = lottoCreateService.createRandomLottoNumbers(inputView.printMoney());
            outputView.printBuyingLotto(lottoTicket);
            return Optional.of(lottoTicket);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    private Optional<Lotto> getWiningNumbers() {
        try {
            Lotto winingNumbers = lottoCreateService.createWinningLotto(inputView.printWiningNumbers());
            return Optional.of(winingNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    private Optional<Bonus> getBonusNumber() {
        try {
            Bonus bonusNumber = lottoCreateService.createWinningLottoBonus(inputView.printBonusNumber());
            return Optional.of(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    private WiningTypeCount matchLotto(List<Lotto> lottoTicket, WiningNumbers winingNumbers) {
        LottoMatchService lottoMatchService = new LottoMatchService();
        return lottoMatchService.matchLottoTicket(winingNumbers, lottoTicket);
    }

    private void result(WiningTypeCount winingTypeCount, int lottoCount) {
        StatisticsService statisticsService = new StatisticsService();
        WiningStatistics winingStatistics =
                statisticsService.calculateWiningStatistics(winingTypeCount, lottoCount);
        outputView.printWiningStatistics(winingStatistics);
    }
}
