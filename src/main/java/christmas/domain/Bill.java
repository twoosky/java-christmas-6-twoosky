package christmas.domain;

import java.util.function.Supplier;

public class Benefit {
    public static final int MINIMUM_ORDERS_PRICE = 10000;
    public static final int EVENT_NOT_APPLIED_AMOUNT = 0;

    private final Discounts discounts;
    private final Gifts gifts;

    public Benefit(Discounts discounts, Gifts gifts) {
        this.discounts = discounts;
        this.gifts = gifts;
    }

    public int getTotalDiscount(Orders orders) {
        return getAmount(discounts::sumDiscount, orders);
    }

    public int getTotalBenefit(Orders orders) {
        return getAmount(this::sumBenefit, orders);
    }

    public int getPaymentAfterDiscount(Orders orders) {
        return orders.getTotalPrice() - discounts.sumDiscount();
    }

    private int sumBenefit() {
        return discounts.sumDiscount() + gifts.sumPrice();
    }

    private boolean isEventApplicable(Orders orders) {
        return orders.getTotalPrice() >= MINIMUM_ORDERS_PRICE;
    }

    private <T> int getAmount(Supplier<T> supplier, Orders orders) {
        if (isEventApplicable(orders)) {
            return (int) supplier.get();
        }
        return EVENT_NOT_APPLIED_AMOUNT;
    }
}
