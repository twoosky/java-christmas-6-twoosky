package christmas.domain;

import christmas.exception.InvalidDateException;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class VisitDate {
    private static final int YEAR = 2023;
    public static final int MONTH = 12;
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

    public DayOfWeek getDayOfWeek() {
        LocalDate localDate = LocalDate.of(YEAR, MONTH, date);
        return localDate.getDayOfWeek();
    }
}
