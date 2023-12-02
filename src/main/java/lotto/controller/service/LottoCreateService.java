package lotto.controller.service;

import java.util.List;
import lotto.domain.entity.Bonus;
import lotto.domain.entity.Lotto;
import lotto.domain.entity.LottoMoney;
import lotto.domain.generator.LottoGenerator;

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
