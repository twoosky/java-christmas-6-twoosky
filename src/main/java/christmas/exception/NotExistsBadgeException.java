package christmas.exception;

import static christmas.exception.ErrorMessages.NOT_EXISTS_BADGE;

public class NotExistsBadgeException extends IllegalStateException {
    public NotExistsBadgeException() {
        super(NOT_EXISTS_BADGE);
    }
}
