package christmas.domain.policy.discount;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.SATURDAY;

import christmas.domain.MenuType;
import christmas.domain.Orders;
import christmas.domain.VisitDate;
import java.time.DayOfWeek;
import java.util.List;

public class WeekendDiscountPolicy implements DiscountPolicy {
    private static final List<DayOfWeek> WEEKEND = List.of(FRIDAY, SATURDAY);
    public static final int DISCOUNT_AMOUNT = 2023;
    public static final int NOT_DISCOUNT_AMOUNT = 0;

    @Override
    public int discount(VisitDate visitDate, Orders orders) {
        if (isWeekend(visitDate)) {
            return calculateDiscount(orders);
        }
        return NOT_DISCOUNT_AMOUNT;
    }

    private boolean isWeekend(VisitDate visitDate) {
        return visitDate.isContainDayOfDay(WEEKEND);
    }

    private int calculateDiscount(Orders orders) {
        int desertOrderQuantity = orders.sumOrderQuantityByMenuType(MenuType.MAIN);
        return desertOrderQuantity * DISCOUNT_AMOUNT;
    }
}
