package christmas.domain;

import christmas.domain.policy.discount.DiscountPolicy;

public class Discount {
    private final DiscountType type;
    private final DiscountPolicy policy;

    public Discount(DiscountType type, DiscountPolicy policy) {
        this.type = type;
        this.policy = policy;
    }

    public int discount(VisitDate visitDate, Orders orders) {
        return policy.discount(visitDate, orders);
    }
}
