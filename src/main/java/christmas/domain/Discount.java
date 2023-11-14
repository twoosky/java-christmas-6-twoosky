package christmas.domain;

import java.util.Map;

public class Discount {
    private final DiscountType type;
    private final int amount;

    public Discount(DiscountType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public boolean isDiscount() {
        return amount != 0;
    }

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return type.getName();
    }
}
