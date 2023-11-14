package christmas;

import static christmas.domain.DiscountType.CHRISTMAS_DDAY;
import static christmas.domain.DiscountType.SPECIAL;
import static christmas.domain.DiscountType.WEEKDAY;
import static christmas.domain.DiscountType.WEEKEND;
import static christmas.domain.GiftType.CHAMPAGNE;

import christmas.controller.EventController;
import christmas.domain.DiscountPolicies;
import christmas.domain.DiscountType;
import christmas.domain.GiftPolicies;
import christmas.domain.GiftType;
import christmas.domain.Restaurant;
import christmas.domain.policy.discount.DdayDiscountPolicy;
import christmas.domain.policy.discount.DiscountPolicy;
import christmas.domain.policy.discount.SpecialDiscountPolicy;
import christmas.domain.policy.discount.WeekdayDiscountPolicy;
import christmas.domain.policy.discount.WeekendDiscountPolicy;
import christmas.domain.policy.gift.GiftPolicy;
import christmas.domain.policy.gift.PriceGiftPolicy;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(createDiscountPolicies(), createGiftPolicies());
        EventController controller = new EventController(restaurant, new InputView(), new OutputView());
        controller.run();
    }

    private static DiscountPolicies createDiscountPolicies() {
        Map<DiscountType, DiscountPolicy> policies = new HashMap<>();
        policies.put(CHRISTMAS_DDAY, new DdayDiscountPolicy());
        policies.put(WEEKDAY, new WeekdayDiscountPolicy());
        policies.put(WEEKEND, new WeekendDiscountPolicy());
        policies.put(SPECIAL, new SpecialDiscountPolicy());

        return new DiscountPolicies(policies);
    }

    private static GiftPolicies createGiftPolicies() {
        Map<GiftType, GiftPolicy> policies = new HashMap<>();
        policies.put(CHAMPAGNE, new PriceGiftPolicy());

        return new GiftPolicies(policies);
    }
}
