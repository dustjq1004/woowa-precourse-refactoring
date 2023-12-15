package lotto.validation;

import static lotto.common.Constants.LIMIT_MONEY;
import static lotto.common.Constants.LOTTO_PRICE;
import static lotto.common.Constants.MAX_LOTTO_NUMBER;
import static lotto.common.Constants.MIN_LOTTO_NUMBER;
import static lotto.common.Constants.REMAINDER_ZERO;
import static lotto.exception.ExceptionMessage.MESSAGE_DUPLICATE_NUMBER;
import static lotto.exception.ExceptionMessage.MESSAGE_LIMIT_MONEY;
import static lotto.exception.ExceptionMessage.MESSAGE_LIMIT_SIZE;
import static lotto.exception.ExceptionMessage.MESSAGE_RANGE_NUMBER;
import static lotto.exception.ExceptionMessage.MESSAGE_THOUSAND_UNIT;
import static lotto.exception.ExceptionMessage.getMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.common.Constants;

public class ModelValidation {

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException(getMessage(MESSAGE_LIMIT_SIZE));
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> validationDuplicate = new HashSet<>(numbers);
        if (numbers.size() != validationDuplicate.size()) {
            throw new IllegalArgumentException(getMessage(MESSAGE_DUPLICATE_NUMBER));
        }
    }

    public static void validateRange(int bonus) {
        if (bonus < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < bonus) {
            throw new IllegalArgumentException(getMessage(MESSAGE_RANGE_NUMBER));
        }
    }

    public static void validateRangeList(List<Integer> numbers) {
        numbers.forEach((number) -> {
            if (number < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < number) {
                throw new IllegalArgumentException(getMessage(MESSAGE_RANGE_NUMBER));
            }
        });
    }

    public static void validateThousandUnit(int money) {
        if (money % LOTTO_PRICE > REMAINDER_ZERO) {
            throw new IllegalArgumentException(getMessage(MESSAGE_THOUSAND_UNIT));
        }
    }

    public static void validateLimit(int money) {
        if (money > LIMIT_MONEY) {
            throw new IllegalArgumentException(getMessage(MESSAGE_LIMIT_MONEY));
        }
    }
}
