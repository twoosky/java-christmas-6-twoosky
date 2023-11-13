package christmas.domain;

import christmas.exception.InvalidDateException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

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

    public boolean isContainDayOfDay(List<DayOfWeek> weekDay) {
        DayOfWeek dayOfWeek = getDayOfWeek();
        return weekDay.contains(dayOfWeek);
    }

    public boolean isEqualsDate(int date) {
        return this.date == date;
    }
}
