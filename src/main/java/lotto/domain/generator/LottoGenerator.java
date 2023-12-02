package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.entity.Lotto;

public class LottoGenerator {

    public Lotto generatorLottoRandom() {
        return generatorLotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public Lotto generatorLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public List<Lotto> generatorLottoTicket(int quantity) {
        List<Lotto> lottoTicket = new ArrayList<>();
        while (lottoTicket.size() < quantity) {
            Lotto lotto = generatorLottoRandom();
            lottoTicket.add(lotto);
        }
        return lottoTicket;
    }
}
