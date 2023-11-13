package christmas.domain.policy;

import christmas.domain.Orders;

public interface GiftPolicy {
    boolean canGive(Orders orders);
}
