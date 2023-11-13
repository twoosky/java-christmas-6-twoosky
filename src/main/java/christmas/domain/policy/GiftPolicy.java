package christmas.domain.policy;

import christmas.domain.GiftType;
import christmas.domain.Orders;

public interface GiftPolicy {
    GiftType give(Orders orders);
}
