package christmas.exception;

import static christmas.exception.ErrorMessages.INVALID_ORDER;

public class InvalidOrderException extends IllegalArgumentException {
    public InvalidOrderException() {
        super(INVALID_ORDER);
    }
}
