package christmas.domain;

import static christmas.domain.GiftType.NONE;

import christmas.domain.policy.GiftPolicy;

public class Gift {
    public static final GiftType NONE_GIFT = NONE;

    private final GiftType type;
    private final GiftPolicy policy;

    public Gift(GiftType type, GiftPolicy policy) {
        this.type = type;
        this.policy = policy;
    }

    public GiftType give(Orders orders) {
        if (policy.canGive(orders)) {
            return type;
        }
        return NONE_GIFT;
    }
}