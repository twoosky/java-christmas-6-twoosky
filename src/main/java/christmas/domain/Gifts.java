package christmas.domain;

import java.util.List;

public class Gifts {
    private final List<Gift> gifts;

    public Gifts(List<Gift> gifts) {
        this.gifts = gifts;
    }

    public int sumPrice(Orders orders) {
        return gifts.stream()
                .mapToInt(gift -> gift.calculatePrice(orders))
                .sum();
    }
}
