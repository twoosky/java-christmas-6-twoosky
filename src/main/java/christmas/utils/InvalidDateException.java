package christmas.utils;

import static christmas.utils.ErrorMessages.INVALID_DATE;

public class InvalidDateException extends IllegalArgumentException {
    public InvalidDateException() {
        super(INVALID_DATE);
    }
}
