package christmas.domain.policy;

import christmas.domain.GiftType;
import christmas.domain.Orders;

public class PriceGiftPolicy implements GiftPolicy {
    public static final int MINIMUM_GIFT_PRICE = 12_000;
    public static final GiftType GIFT = GiftType.CHAMPAGNE;
    public static final GiftType NONE_GIFT = GiftType.NONE;

    @Override
    public GiftType give(Orders orders) {
        if (canGive(orders)) {
            return GIFT;
        }
        return NONE_GIFT;
    }

    private boolean canGive(Orders orders) {
        int totalOrderPrice = orders.calculateTotalOrderPrice();
        return totalOrderPrice >= MINIMUM_GIFT_PRICE;
    }
}
