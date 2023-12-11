package lotto.domain.entity;

import static lotto.common.Constants.MAX_LOTTO_NUMBER;
import static lotto.common.Constants.MIN_LOTTO_NUMBER;
import static lotto.exception.ExceptionMessage.MESSAGE_RANGE_NUMBER;

public class Bonus {

    private final int bonus;

    public Bonus(final int bonus) {
        validateRange(bonus);
        this.bonus = bonus;
    }

    private void validateRange(int bonus) {
        if (bonus < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < bonus) {
            throw new IllegalArgumentException(MESSAGE_RANGE_NUMBER.getMessage());
        }
    }

    public boolean compareNumber(Lotto lotto) {
        return lotto.containNumber(bonus);
    }
}
