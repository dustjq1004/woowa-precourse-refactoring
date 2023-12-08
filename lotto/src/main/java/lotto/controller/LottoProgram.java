package lotto.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import lotto.controller.service.LottoCreateService;
import lotto.controller.service.LottoMatchService;
import lotto.controller.service.StatisticsService;
import lotto.domain.entity.Bonus;
import lotto.domain.entity.Lotto;
import lotto.domain.entity.MatchCount;
import lotto.domain.entity.WiningNumbers;
import lotto.domain.entity.WiningStatistics;
import lotto.exception.ExceptionHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoProgram {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoCreateService lottoCreateService;
    private final ExceptionHandler exceptionHandler;

    public LottoProgram(InputView inputView, OutputView outputView, LottoCreateService lottoCreateService,
                        ExceptionHandler exceptionHandler) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoCreateService = lottoCreateService;
        this.exceptionHandler = exceptionHandler;
    }

    public void run() {
        List<Lotto> lottoTicket = executeMethod(this::purchaseLottoNumbers);
        Lotto winingNumbers = executeMethod(this::getWiningNumbers);
        Bonus bonus = executeMethod(this::getBonusNumber);
        MatchCount matchCount = matchLotto(lottoTicket, new WiningNumbers(winingNumbers, bonus));
        result(matchCount, lottoTicket.size());
    }

    private <T> T executeMethod(Supplier<Optional<T>> methodInput) {
        Optional<T> result;
        do {
            result = exceptionHandler.get(methodInput);
        } while (result.isEmpty());
        return result.get();
    }

    private Optional<List<Lotto>> purchaseLottoNumbers() {
        List<Lotto> lottoTicket = lottoCreateService.createRandomLottoNumbers(inputView.printMoney());
        outputView.printBuyingLotto(lottoTicket);
        return Optional.of(lottoTicket);
    }

    private Optional<Lotto> getWiningNumbers() {
        Lotto winingNumbers = lottoCreateService.createWinningLotto(inputView.printWiningNumbers());
        return Optional.of(winingNumbers);
    }

    private Optional<Bonus> getBonusNumber() {
        Bonus bonusNumber = lottoCreateService.createWinningLottoBonus(inputView.printBonusNumber());
        return Optional.of(bonusNumber);
    }

    private MatchCount matchLotto(List<Lotto> lottoTicket, WiningNumbers winingNumbers) {
        LottoMatchService lottoMatchService = new LottoMatchService();
        return lottoMatchService.matchLottoTicket(winingNumbers, lottoTicket);
    }

    private void result(MatchCount matchCount, int lottoCount) {
        StatisticsService statisticsService = new StatisticsService();
        WiningStatistics winingStatistics =
                statisticsService.calculateWiningStatistics(matchCount, lottoCount);
        outputView.printWiningStatistics(winingStatistics);
    }
}
