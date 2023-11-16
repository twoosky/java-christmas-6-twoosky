package christmas.domain.policy.discount;

import christmas.domain.Orders;
import christmas.domain.VisitDate;

public class DdayDiscountPolicy implements DiscountPolicy {
    public static final int CHRISTMAS_DATE = 25;
    public static final int DISCOUNT_AMOUNT = 1000;
    public static final int ADDITIONAL_DISCOUNT_AMOUNT = 100;
    public static final int NOT_DISCOUNT_AMOUNT = 0;

    @Override
    public int discount(VisitDate visitDate, Orders orders) {
        if (isNotAfter(visitDate)) {
            return calculateDiscount(visitDate);
        }
        return NOT_DISCOUNT_AMOUNT;
    }

    private boolean isNotAfter(VisitDate visitDate) {
        return visitDate.isNotAfter(CHRISTMAS_DATE);
    }

    private int calculateDiscount(VisitDate visitDate) {
        return  DISCOUNT_AMOUNT + visitDate.calculateDiscount(ADDITIONAL_DISCOUNT_AMOUNT);
    }
}
