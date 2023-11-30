package lotto.controller.service;

import java.util.List;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoMoney;
import lotto.utils.LottoGenerator;

public class LottoCreateService {

    private LottoGenerator lottoGenerator;

    public LottoCreateService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> createRandomLottoNumbers(LottoMoney money) {
        return lottoGenerator.generatorLottoTicket(money.calculateCountLottoPrice());
    }

    public Lotto createWinningLotto(List<Integer> numbers) {
        return lottoGenerator.generatorLotto(numbers);
    }

    public Bonus createWinningLottoBonus(int bonus) {
        return new Bonus(bonus);
    }
}
