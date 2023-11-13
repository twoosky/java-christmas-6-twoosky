package christmas.domain.policy;

import christmas.domain.Orders;
import christmas.domain.VisitDate;

public interface DiscountPolicy {
    int discount(VisitDate visitDate, Orders orders);
}
