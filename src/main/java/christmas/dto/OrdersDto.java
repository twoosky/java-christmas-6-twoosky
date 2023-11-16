package christmas.dto;

import java.util.Map;

public record OrdersDto(
        Map<String, Integer> orders
) {}
