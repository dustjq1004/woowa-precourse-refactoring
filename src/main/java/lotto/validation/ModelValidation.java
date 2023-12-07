package lotto.validation;

import static lotto.common.Constants.LIMIT_MONEY;
import static lotto.common.Constants.LOTTO_PRICE;
import static lotto.common.Constants.MAX_LOTTO_NUMBER;
import static lotto.common.Constants.MIN_LOTTO_NUMBER;
import static lotto.common.Constants.REMAINDER_ZERO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.common.Constants;
import lotto.exception.ClientException;
import lotto.exception.ExceptionMessage;

public class ModelValidation {

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_SIZE) {
            throw new ClientException(ExceptionMessage.MESSAGE_LIMIT_SIZE.getMessage());
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> validationDuplicate = new HashSet<>(numbers);
        if (numbers.size() != validationDuplicate.size()) {
            throw new ClientException(ExceptionMessage.MESSAGE_DUPLICATE_NUMBER.getMessage());
        }
    }

    public static void validateRange(List<Integer> numbers) {
        numbers.forEach((number) -> {
            if (number < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < number) {
                throw new ClientException(ExceptionMessage.MESSAGE_RANGE_NUMBER.getMessage());
            }
        });
    }

    public static void validateThousandUnit(int money) {
        if (money % LOTTO_PRICE > REMAINDER_ZERO) {
            throw new ClientException(ExceptionMessage.MESSAGE_THOUSAND_UNIT.getMessage());
        }
    }

    public static void validateLimit(int money) {
        if (money > LIMIT_MONEY) {
            throw new ClientException(ExceptionMessage.MESSAGE_LIMIT_MONEY.getMessage());
        }
    }
}
