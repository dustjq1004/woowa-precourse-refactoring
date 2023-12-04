package lotto.controller.service;

import java.util.List;
import lotto.domain.entity.Lotto;
import lotto.domain.entity.MatchCount;
import lotto.domain.entity.WiningNumbers;

public class LottoMatchService {

    public MatchCount matchLottoTicket(WiningNumbers winingNumbers, List<Lotto> lottoTicket) {
        return winingNumbers.countWining(lottoTicket);
    }
}
