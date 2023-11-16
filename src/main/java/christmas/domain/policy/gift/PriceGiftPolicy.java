package christmas.domain.policy.gift;

import christmas.domain.Orders;

public class PriceGiftPolicy implements GiftPolicy {
    public static final int MINIMUM_GIFT_PRICE = 120_000;
    public static final int GIFT_QUANTITY = 1;
    public static final int NONE_GIFT_QUANTITY = 0;

    public int calculateGiftQuantity(Orders orders) {
        if (canGive(orders)) {
            return GIFT_QUANTITY;
        }
        return NONE_GIFT_QUANTITY;
    }

    private boolean canGive(Orders orders) {
        int totalOrderPrice = orders.getTotalPrice();
        return totalOrderPrice >= MINIMUM_GIFT_PRICE;
    }
}
