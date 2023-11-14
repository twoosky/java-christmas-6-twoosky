package christmas.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Discounts {
    private final List<Discount> discounts;

    public Discounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public int sumDiscount() {
        return discounts.stream()
                .mapToInt(Discount::getAmount)
                .sum();
    }

    public Map<DiscountType, Integer> getResult() {
        Map<DiscountType, Integer> result = new EnumMap<>(DiscountType.class);
        discounts.forEach(discount -> discount.addResult(result));
        return result;
    }
}
