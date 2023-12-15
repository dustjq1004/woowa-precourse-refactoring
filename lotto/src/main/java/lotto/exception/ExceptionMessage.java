package lotto.exception;

public enum ExceptionMessage {

    MESSAGE_IS_NUMERIC("숫자만 입력 가능합니다."),
    MESSAGE_COMMA_NUMERIC("숫자와 숫자 구분으로 쉼표만 입력 가능합니다."),
    MESSAGE_THOUSAND_UNIT("1000원 단위만 입력 가능합니다."),
    MESSAGE_LIMIT_MONEY("1,000,000 만원 까지 입력 가능합니다."),
    MESSAGE_RANGE_NUMBER("1 ~ 45 까지 입력 가능합니다."),
    MESSAGE_LIMIT_SIZE("로또 번호는 6개까지 입력 가능합니다."),
    MESSAGE_DUPLICATE_NUMBER("로또 번호는 6개까지 입력 가능합니다.");

    private static final String PREFIX = "[ERROR]";
    private static final String SPACE = " ";
    private String message;

    ExceptionMessage(String message) {
        this.message = PREFIX + SPACE + message;
    }

    public static String getMessage(ExceptionMessage exceptionMessage) {
        return exceptionMessage.message;
    }
}
