package christmas.domain;

import christmas.domain.policy.gift.GiftPolicy;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GiftPolicies {
    private final Map<GiftType, GiftPolicy> policies;

    public GiftPolicies(Map<GiftType, GiftPolicy> policies) {
        this.policies = policies;
    }

    public Gifts createGifts(Orders orders) {
        List<Gift> gifts = policies.entrySet().stream()
                .map(it -> createGift(it, orders))
                .toList();

        return new Gifts(gifts);
    }

    private Gift createGift(Entry<GiftType, GiftPolicy> entry, Orders orders) {
        GiftPolicy policy = entry.getValue();
        return new Gift(entry.getKey(), policy.calculateGiftQuantity(orders));
    }
}
