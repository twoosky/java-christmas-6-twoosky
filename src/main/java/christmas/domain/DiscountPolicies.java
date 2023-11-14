package christmas.domain;

import christmas.domain.policy.discount.DiscountPolicy;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DiscountPolicies {
    private final Map<DiscountType, DiscountPolicy> policies;

    public DiscountPolicies(Map<DiscountType, DiscountPolicy> policies) {
        this.policies = policies;
    }

    public Discounts createDiscounts(VisitDate visitDate, Orders orders) {
        List<Discount> discounts = policies.entrySet().stream()
                .map(it -> createDiscount(it, visitDate, orders))
                .toList();

        return new Discounts(discounts);
    }

    private Discount createDiscount(Entry<DiscountType, DiscountPolicy> entry, VisitDate visitDate, Orders orders) {
        DiscountPolicy policy = entry.getValue();
        return new Discount(entry.getKey(), policy.discount(visitDate, orders));
    }
}
