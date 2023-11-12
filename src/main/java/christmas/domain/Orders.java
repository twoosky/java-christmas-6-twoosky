package christmas.domain;

import christmas.utils.InvalidOrderException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Orders {
    public static final String ORDER_DELIMITER = ",";
    public static final String MENU_AND_QUANTITY_DELIMITER = "-";
    public static final int MAX_ORDER_QUANTITY = 20;

    private final List<Order> orders;

    public Orders(String orders) {
        validateFormat(orders);
        this.orders = createOrders(orders);

        validateOverQuantity();
        validateDuplicate();
        validateAllDrink();
    }

    private List<Order> createOrders(String value) {
        return getOrdersStream(value)
                .map(order -> new Order(order[0], order[1]))
                .toList();
    }

    private void validateFormat(String value) {
        if (isInvalidFormat(value)) {
            throw new InvalidOrderException();
        }
    }

    private boolean isInvalidFormat(String value) {
        return getOrdersStream(value)
                .anyMatch(order -> order.length != 2);
    }

    private Stream<String[]> getOrdersStream(String value) {
        return Arrays.stream(value.split(ORDER_DELIMITER))
                .map(order -> order.split(MENU_AND_QUANTITY_DELIMITER));
    }

    private void validateOverQuantity() {
        if (sumOrderQuantity() > MAX_ORDER_QUANTITY) {
            throw new InvalidOrderException();
        }
    }

    private int sumOrderQuantity() {
        return orders.stream()
                .mapToInt(Order::getQuantity)
                .sum();
    }


}
