package christmas.constant.exception;

public enum ErrorMessage {

    MENU_ERROR_MESSAGE("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    DATE_ERROR_MESSAGE("유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private static final String MESSAGE_PREFIX = "[ERROR] ";

    private String message;

    ErrorMessage(final String message) {
        this.message = MESSAGE_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
