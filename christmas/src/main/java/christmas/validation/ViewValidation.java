package christmas.validation;

import christmas.constant.exception.ErrorMessage;

public class ViewValidation {

    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;

    public static void validateReservationDate(final String date) {
        final int parsedDate = validateNumberFormat(date);

        if (parsedDate < MIN_DATE && MAX_DATE < parsedDate) {
            throw new IllegalArgumentException(ErrorMessage.DATE_ERROR_MESSAGE.getMessage());
        }
    }

    private static int validateNumberFormat(final String date) {
        try {
            return Integer.parseInt(date);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorMessage.DATE_ERROR_MESSAGE.getMessage());
        }
    }
}
