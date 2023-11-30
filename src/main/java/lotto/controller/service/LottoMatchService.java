package lotto.controller.service;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WiningNumbers;
import lotto.model.WiningTypeCount;

public class LottoMatchService {

    public WiningTypeCount matchLottoTicket(WiningNumbers winingNumbers, List<Lotto> lottoTicket) {
        return winingNumbers.countWining(lottoTicket);
    }
}
