package lotto.controller.service;

import java.util.List;
import lotto.domain.entity.Bonus;
import lotto.domain.entity.Lotto;
import lotto.domain.entity.LottoMoney;
import lotto.domain.generator.LottoGenerator;

public class LottoCreateService {

    public List<Lotto> createRandomLottoNumbers(LottoMoney money) {
        return LottoGenerator.generatorLottoTicket(money.calculateCountLottoPrice());
    }

    public Lotto createWinningLotto(List<Integer> numbers) {
        return LottoGenerator.generatorLotto(numbers);
    }

    public Bonus createWinningLottoBonus(int bonus) {
        return new Bonus(bonus);
    }
}
