package christmas.exception;

import static christmas.exception.ErrorMessages.INVALID_DATE;

public class InvalidDateException extends IllegalArgumentException {
    public InvalidDateException() {
        super(INVALID_DATE);
    }
}
