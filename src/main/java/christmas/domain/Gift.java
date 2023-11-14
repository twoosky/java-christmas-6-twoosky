package christmas.domain;

import java.util.Map;

public class Gift {
    private final GiftType type;
    private final int quantity;

    public Gift(GiftType type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public int calculatePrice() {
        return type.getPrice() * quantity;
    }

    public void addResult(Map<GiftType, Integer> result) {
        if (isGiven()) {
            result.put(type, quantity);
        }
    }

    private boolean isGiven() {
        return quantity != 0;
    }
}