package christmas.domain;

public class Event {
    private final Discounts discounts;
    private final Gifts gifts;

    public Event(Discounts discounts, Gifts gifts) {
        this.discounts = discounts;
        this.gifts = gifts;
    }

    public int sumBenefitsAmount(VisitDate visitDate, Orders orders) {
        return discounts.calculateTotalDiscount(visitDate, orders) + gifts.calculateTotalPrice(orders);
    }
}
