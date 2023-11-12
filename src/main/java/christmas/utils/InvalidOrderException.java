package christmas.utils;

import static christmas.utils.ErrorMessages.INVALID_ORDER;

public class InvalidOrderException extends IllegalArgumentException {
    public InvalidOrderException() {
        super(INVALID_ORDER);
    }
}
