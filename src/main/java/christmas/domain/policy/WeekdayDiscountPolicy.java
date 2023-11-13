package christmas.domain.policy;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;

import christmas.domain.Orders;
import christmas.domain.VisitDate;
import java.time.DayOfWeek;
import java.util.List;

public class WeekdayDiscountPolicy implements DiscountPolicy {
    private static final List<DayOfWeek> WEEK_DAY = List.of(SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY);
    public static final int DISCOUNT_AMOUNT = 2023;
    public static final int DEFAULT_DISCOUNT_AMOUNT = 0;

    @Override
    public int discount(VisitDate visitDate, Orders orders) {
        if (isWeekDay(visitDate)) {
            return calculateDiscountAmount(orders);
        }
        return DEFAULT_DISCOUNT_AMOUNT;
    }

    private boolean isWeekDay(VisitDate visitDate) {
        return visitDate.isContainDayOfDay(WEEK_DAY);
    }

    private int calculateDiscountAmount(Orders orders) {
        int desertOrderQuantity = orders.sumDesertOrderQuantity();
        return desertOrderQuantity * DISCOUNT_AMOUNT;
    }
}
