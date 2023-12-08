package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.entity.Lotto;

public class LottoGenerator {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;

    private static final LottoGenerator lottoGenerator;

    static {
        lottoGenerator = new LottoGenerator();
    }

    private LottoGenerator() {
    }

    public static Lotto generatorLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public static List<Lotto> generatorLottoTicket(int quantity) {
        List<Lotto> lottoTicket = new ArrayList<>();
        while (lottoTicket.size() < quantity) {
            Lotto lotto = lottoGenerator.generatorLottoRandom();
            lottoTicket.add(lotto);
        }
        return lottoTicket;
    }

    private Lotto generatorLottoRandom() {
        return generatorLotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT));
    }
}
