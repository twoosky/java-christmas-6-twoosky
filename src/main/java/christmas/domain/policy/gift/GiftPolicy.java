package christmas.domain.policy.gift;

import christmas.domain.Orders;

public interface GiftPolicy {
    int calculateGiftQuantity(Orders orders);
}
