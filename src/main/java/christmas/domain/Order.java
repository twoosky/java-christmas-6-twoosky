package christmas.domain;

public class Order {
    private final Menu menu;
    private final int quantity;

    public Order(String menu, int quantity) {
        this.menu = Menu.from(menu);
        this.quantity = quantity;
    }
}
