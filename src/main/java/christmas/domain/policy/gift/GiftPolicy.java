package christmas.domain.policy.gift;

import christmas.domain.Orders;

public interface GiftPolicy {
    boolean canGive(Orders orders);
}
