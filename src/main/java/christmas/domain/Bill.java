package christmas.domain;

import christmas.dto.EventsDto;
import java.util.function.Supplier;

public class Event {
    public static final int MINIMUM_ORDERS_PRICE = 10000;
    public static final int EVENT_NOT_APPLIED_AMOUNT = 0;

    private final Discounts discounts;
    private final Gifts gifts;

    public Event(Discounts discounts, Gifts gifts) {
        this.discounts = discounts;
        this.gifts = gifts;
    }

    public int getTotalDiscount(VisitDate visitDate, Orders orders) {
        return getAmount(() -> discounts.sumDiscount(visitDate, orders), orders);
    }

    public int getTotalBenefit(VisitDate visitDate, Orders orders) {
        return getAmount(() -> sumBenefit(visitDate, orders), orders);
    }

    public int getPaymentAfterDiscount(VisitDate visitDate, Orders orders) {
        return orders.getTotalPrice() - discounts.sumDiscount(visitDate, orders);
    }

    public EventsDto getDiscountsResult() {

    }

    private int sumBenefit(VisitDate visitDate, Orders orders) {
        return discounts.sumDiscount(visitDate, orders) + gifts.sumPrice(orders);
    }

    private boolean isEventApplicable(Orders orders) {
        return orders.getTotalPrice() >= MINIMUM_ORDERS_PRICE;
    }

    private <T> int getAmount(Supplier<T> supplier, Orders orders) {
        if (isEventApplicable(orders)) {
            return (int) supplier.get();
        }
        return EVENT_NOT_APPLIED_AMOUNT;
    }
}
