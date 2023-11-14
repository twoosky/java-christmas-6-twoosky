package christmas.domain;

public enum GiftType {
    CHAMPAGNE("샴페인", 25000);

    private final String name;
    private final int price;

    private GiftType(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
