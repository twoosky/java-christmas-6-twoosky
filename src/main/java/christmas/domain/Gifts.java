package christmas.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

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

    public Map<GiftType, Integer> getResult() {
        Map<GiftType, Integer> result = new EnumMap<>(GiftType.class);
        gifts.forEach(gift -> gift.addResult(result));
        return result;
    }
}
