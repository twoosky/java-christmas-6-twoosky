package christmas.domain.policy;

import static java.time.DayOfWeek.SUNDAY;

import christmas.domain.Orders;
import christmas.domain.VisitDate;
import java.time.DayOfWeek;
import java.util.List;

public class SpecialDiscountPolicy implements DiscountPolicy {
    private static final List<DayOfWeek> SPECIAL_DAY_OF_WEEK = List.of(SUNDAY);
    private static final int CHRISTMAS_DATE = 25;
    public static final int DISCOUNT_AMOUNT = 1000;
    public static final int NOT_DISCOUNT_AMOUNT = 0;

    @Override
    public int discount(VisitDate visitDate, Orders orders) {
        if (isSpecialDay(visitDate)) {
            return DISCOUNT_AMOUNT;
        }
        return NOT_DISCOUNT_AMOUNT;
    }

    private boolean isSpecialDay(VisitDate visitDate) {
        return visitDate.isEqualsDate(CHRISTMAS_DATE) ||
                visitDate.isContainDayOfDay(SPECIAL_DAY_OF_WEEK);
    }
}
