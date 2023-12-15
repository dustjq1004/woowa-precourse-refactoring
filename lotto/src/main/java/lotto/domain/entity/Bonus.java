package lotto.domain.entity;

import lotto.validation.ModelValidation;

public class Bonus {

    private final int bonus;

    public Bonus(final int bonus) {
        validate(bonus);
        this.bonus = bonus;
    }

    private void validate(int bonus) {
        ModelValidation.validateRange(bonus);
    }

    public boolean compareNumber(Lotto lotto) {
        return lotto.containNumber(bonus);
    }
}
