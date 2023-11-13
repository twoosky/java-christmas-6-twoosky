package christmas.domain.policy;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;

import christmas.domain.MenuType;
import christmas.domain.Orders;
import christmas.domain.VisitDate;
import java.time.DayOfWeek;
import java.util.List;

public class WeekdayDiscountPolicy implements DiscountPolicy {
    private static final List<DayOfWeek> WEEKDAY = List.of(SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY);
    public static final int DISCOUNT_AMOUNT = 2023;
    public static final int NOT_DISCOUNT_AMOUNT = 0;

    @Override
    public int discount(VisitDate visitDate, Orders orders) {
        if (isWeekday(visitDate)) {
            return calculateDiscount(orders);
        }
        return NOT_DISCOUNT_AMOUNT;
    }

    private boolean isWeekday(VisitDate visitDate) {
        return visitDate.isContainDayOfDay(WEEKDAY);
    }

    private int calculateDiscount(Orders orders) {
        int desertOrderQuantity = orders.sumOrderQuantityByMenuType(MenuType.DESSERT);
        return desertOrderQuantity * DISCOUNT_AMOUNT;
    }
}
