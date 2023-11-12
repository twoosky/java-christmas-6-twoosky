package christmas.domain;

import static christmas.utils.ErrorMessages.INVALID_ORDER;

import christmas.utils.IntegerConverter;

public class Order {
    private final Menu menu;
    private final int quantity;

    public Order(String menu, String quantity) {
        this.menu = Menu.from(menu);
        this.quantity = convertType(quantity);
    }

    private int convertType(String quantity) {
        return IntegerConverter.convert(quantity, INVALID_ORDER);
    }
}
