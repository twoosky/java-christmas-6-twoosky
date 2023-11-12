package christmas.domain;

import static christmas.utils.ErrorMessages.INVALID_ORDER;

import christmas.utils.IntegerConverter;
import christmas.utils.InvalidOrderException;

public class Order {
    public static final int MIN_ORDER_QUANTITY = 1;
    private final Menu menu;
    private final int quantity;

    public Order(String menuName, String quantity) {
        this.menu = Menu.from(menuName);
        this.quantity = convertType(quantity);

        validateMinQuantity();
    }

    private int convertType(String quantity) {
        return IntegerConverter.convert(quantity, INVALID_ORDER);
    }

    private void validateMinQuantity() {
        if (quantity < MIN_ORDER_QUANTITY) {
            throw new InvalidOrderException();
        }
    }

    public boolean isDrinkOrder() {
        return menu.isDrinkMenu();
    }

    public int getQuantity() {
        return quantity;
    }

    public Menu getMenu() {
        return menu;
    }
}
