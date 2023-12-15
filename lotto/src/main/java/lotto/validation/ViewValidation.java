package lotto.validation;

import static lotto.exception.ExceptionMessage.MESSAGE_COMMA_NUMERIC;
import static lotto.exception.ExceptionMessage.MESSAGE_IS_NUMERIC;
import static lotto.exception.ExceptionMessage.getMessage;

import java.util.regex.Pattern;

public class ViewValidation {

    private final static Pattern NUMERIC_REGEX = Pattern.compile("\\d+");
    private final static Pattern COMMA_NUMERIC_REGEX = Pattern.compile("^[0-9,]+$");

    public static void validateNumeric(String number) {
        if (!NUMERIC_REGEX.matcher(number).matches()) {
            throw new IllegalArgumentException(getMessage(MESSAGE_IS_NUMERIC));
        }
    }

    public static void validateCommaNumeric(String numbers) {
        if (!COMMA_NUMERIC_REGEX.matcher(numbers).matches()) {
            throw new IllegalArgumentException(getMessage(MESSAGE_COMMA_NUMERIC));
        }
    }
}
