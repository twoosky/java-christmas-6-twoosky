package christmas.domain;

import christmas.utils.InvalidDateException;

public class VisitDate {
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;

    private final int date;

    public VisitDate(int date) {
        validateDateRange(date);
        this.date = date;
    }

    private void validateDateRange(int date) {
        if (date < MIN_DATE || date > MAX_DATE) {
            throw new InvalidDateException();
        }
    }
}
