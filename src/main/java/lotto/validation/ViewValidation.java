package lotto.validation;

import java.util.regex.Pattern;
import lotto.exception.ClientException;
import lotto.exception.ExceptionMessage;

public class ViewValidation {

    private final static Pattern NUMERIC_REGEX = Pattern.compile("\\d+");
    private final static Pattern COMMA_NUMERIC_REGEX = Pattern.compile("^[0-9,]+$");

    public static void validateNumeric(String number) {
        if (!NUMERIC_REGEX.matcher(number).matches()) {
            throw new ClientException(ExceptionMessage.MESSAGE_IS_NUMERIC.getMessage());
        }
    }

    public static void validateCommaNumeric(String numbers) {
        if (!COMMA_NUMERIC_REGEX.matcher(numbers).matches()) {
            throw new ClientException(ExceptionMessage.MESSAGE_COMMA_NUMERIC.getMessage());
        }
    }
}
