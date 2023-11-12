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

        validateMinQuantity(quantity);
        this.quantity = convertType(quantity);
    }

    private int convertType(String quantity) {
        return IntegerConverter.convert(quantity, INVALID_ORDER);
    }

    private void validateMinQuantity(String value) {
        int quantity = convertType(value);
        if (quantity < MIN_ORDER_QUANTITY) {
            throw new InvalidOrderException();
        }
    }
}
