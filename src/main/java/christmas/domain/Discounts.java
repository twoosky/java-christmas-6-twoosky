package christmas.domain;

import java.util.List;

public class Discounts {
    public static final int MINIMUM_ORDERS_PRICE = 10000;
    public static final int NONE_DISCOUNT = 0;

    private final List<Discount> discounts;

    public Discounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public int calculateTotalDiscount(VisitDate visitDate, Orders orders) {
        if (canDiscount(orders)) {
            return sumDiscount(visitDate, orders);
        }
        return NONE_DISCOUNT;
    }

    private boolean canDiscount(Orders orders) {
        return orders.calculateTotalPrice() >= MINIMUM_ORDERS_PRICE;
    }

    private int sumDiscount(VisitDate visitDate, Orders orders) {
        return discounts.stream()
                .mapToInt(discount -> discount.discount(visitDate, orders))
                .sum();
    }
}
