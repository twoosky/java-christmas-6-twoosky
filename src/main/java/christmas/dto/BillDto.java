package christmas.dto;

import java.util.Map;

public record BillDto(
        int totalOrderPrice,
        GiftsDto gifts,
        BenefitDto benefit,
        int totalBenefitAmount,
        int totalPriceAfterDiscount
) {
}