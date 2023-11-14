package christmas.domain;

import christmas.dto.OrdersDto;
import christmas.exception.InvalidOrderException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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

    private void validateDuplicate() {
        if (countUniqueOrderMenu() != orders.size()) {
            throw new InvalidOrderException();
        }
    }

    private int countUniqueOrderMenu() {
        return (int) orders.stream()
                .map(Order::getMenu)
                .distinct()
                .count();
    }

    private void validateAllDrink() {
        if (isAllDrinkMenu()) {
            throw new InvalidOrderException();
        }
    }

    private boolean isAllDrinkMenu() {
        return orders.stream()
                .allMatch(order -> order.isEqualsMenuType(MenuType.DRINK));
    }

    public int getTotalPrice() {
        return orders.stream()
                .mapToInt(Order::calculatePrice)
                .sum();
    }

    public int getQuantityByMenuType(MenuType type) {
        return orders.stream()
                .filter(order -> order.isEqualsMenuType(type))
                .mapToInt(Order::getQuantity)
                .sum();
    }

    public OrdersDto getOrders() {
        Map<String, Integer> result = orders.stream()
                .collect(Collectors.toUnmodifiableMap(Order::getMenuName, Order::getQuantity));

        return new OrdersDto(result);
    }
}
