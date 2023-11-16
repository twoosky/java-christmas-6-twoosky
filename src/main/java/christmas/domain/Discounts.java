package christmas.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Map<String, Integer> getResult() {
        return discounts.stream()
                .filter(Discount::isDiscount)
                .collect(Collectors.toUnmodifiableMap(Discount::getName, Discount::getAmount));
    }
}
