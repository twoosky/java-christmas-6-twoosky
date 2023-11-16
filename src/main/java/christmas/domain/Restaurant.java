package christmas.domain;

public class Restaurant {
    private final DiscountPolicies discountPolicies;
    private final GiftPolicies giftPolicies;

    public Restaurant(DiscountPolicies discountPolicies, GiftPolicies giftPolicies) {
        this.discountPolicies = discountPolicies;
        this.giftPolicies = giftPolicies;
    }

    public Bill order(VisitDate visitDate, Orders orders) {
        Discounts discounts = discountPolicies.createDiscounts(visitDate, orders);
        Gifts gifts = giftPolicies.createGifts(orders);
        return new Bill(discounts, gifts);
    }
}
