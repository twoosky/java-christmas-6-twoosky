package christmas.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Gifts {
    private final List<Gift> gifts;

    public Gifts(List<Gift> gifts) {
        this.gifts = gifts;
    }

    public int sumPrice() {
        return gifts.stream()
                .mapToInt(Gift::calculatePrice)
                .sum();
    }

    public Map<String, Integer> getResult() {
        return gifts.stream()
                .filter(Gift::isGiven)
                .collect(Collectors.toUnmodifiableMap(Gift::getGiftName, Gift::getQuantity));
    }
}
