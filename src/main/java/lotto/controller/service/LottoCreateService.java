package lotto.controller.service;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoMoney;
import lotto.utils.LottoGenerator;

public class LottoCreateService {

    private LottoGenerator lottoGenerator;

    public LottoCreateService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> createLottoNumbers(LottoMoney money) {
        return lottoGenerator.generatorLottoTicket(money.calculateCountLottoPrice());
    }
}
