package christmas.domain;

import java.util.List;

public class Discounts {
    private final List<Discount> discounts;

    public Discounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public int calculateTotalDiscount(VisitDate visitDate, Orders orders) {
        return discounts.stream()
                .mapToInt(discount -> discount.discount(visitDate, orders))
                .sum();
    }
}
