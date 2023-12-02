package lotto.controller.service;

import java.util.List;
import lotto.domain.entity.Lotto;
import lotto.domain.entity.WiningNumbers;
import lotto.domain.entity.WiningTypeCount;

public class LottoMatchService {

    public WiningTypeCount matchLottoTicket(WiningNumbers winingNumbers, List<Lotto> lottoTicket) {
        return winingNumbers.countWining(lottoTicket);
    }
}
