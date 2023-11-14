package christmas.domain;

import java.util.Map;

public class Discount {
    private final DiscountType type;
    private final int amount;

    public Discount(DiscountType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void addResult(Map<DiscountType, Integer> result) {
        if (isDiscounted()) {
            result.put(type, amount);
        }
    }

    private boolean isDiscounted() {
        return amount != 0;
    }
}
