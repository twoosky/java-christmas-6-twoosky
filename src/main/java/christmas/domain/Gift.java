package christmas.domain;

import christmas.domain.policy.gift.GiftPolicy;

public class Gift {
    private final GiftType type;
    private final GiftPolicy policy;

    public Gift(GiftType type, GiftPolicy policy) {
        this.type = type;
        this.policy = policy;
    }

    public int calculatePrice(Orders orders) {
        return type.getPrice() * getQuantity(orders);
    }

    private int getQuantity(Orders orders) {
        return policy.calculateGiftQuantity(orders);
    }
}