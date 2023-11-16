package christmas.domain;

public enum GiftType {
    CHAMPAGNE("샴페인", 25_000);

    private final String name;
    private final int price;

    private GiftType(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int calculatePrice(int quantity) {
        return this.price * quantity;
    }

    public String getName() {
        return name;
    }
}
