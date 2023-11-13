package christmas.domain.policy.gift;

import christmas.domain.Orders;

public class PriceGiftPolicy implements GiftPolicy {
    public static final int MINIMUM_GIFT_PRICE = 120_000;

    public boolean canGive(Orders orders) {
        int totalOrderPrice = orders.calculateTotalOrderPrice();
        return totalOrderPrice >= MINIMUM_GIFT_PRICE;
    }
}
