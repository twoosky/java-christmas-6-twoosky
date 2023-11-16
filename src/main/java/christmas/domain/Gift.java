package christmas.domain;

public class Gift {
    private final GiftType type;
    private final int quantity;

    public Gift(GiftType type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public int calculatePrice() {
        return type.calculatePrice(quantity);
    }

    public boolean isGiven() {
        return quantity != 0;
    }

    public String getGiftName() {
        return type.getName();
    }

    public int getQuantity() {
        return quantity;
    }
}