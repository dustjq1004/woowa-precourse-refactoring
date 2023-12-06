package lotto.exception;

import java.util.Optional;
import java.util.function.Supplier;

public class ExceptionHandler {

    public <T> Optional<T> get(Supplier<Optional<T>> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }
}
