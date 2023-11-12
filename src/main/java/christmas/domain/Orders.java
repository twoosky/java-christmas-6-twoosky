package christmas.domain;

import christmas.utils.InvalidOrderException;
import java.util.Arrays;

public class Orders {
    public static final String ORDER_DELIMITER = ",";
    public static final String MENU_AND_QUANTITY_DELIMITER = "-";

    public Orders(String orders) {
        validateFormat(orders);
    }

    private void validateFormat(String value) {
        if (isInvalidFormat(value)) {
            throw new InvalidOrderException();
        }
    }

    private boolean isInvalidFormat(String value) {
        String[] orders = value.split(ORDER_DELIMITER);
        return Arrays.stream(orders)
                .map(order -> order.split(MENU_AND_QUANTITY_DELIMITER))
                .anyMatch(split -> split.length != 2);
    }
}
