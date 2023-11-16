package christmas.dto;

import java.util.Map;

public record BenefitDto(
        Map<String, Integer> discounts,
        int giftPrice
) {}
