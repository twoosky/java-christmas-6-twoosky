package christmas.domain;

import static christmas.domain.DiscountType.CHRISTMAS_DDAY;
import static christmas.domain.DiscountType.SPECIAL;
import static christmas.domain.DiscountType.WEEKDAY;
import static christmas.domain.DiscountType.WEEKEND;

import christmas.domain.policy.discount.DdayDiscountPolicy;
import christmas.domain.policy.discount.DiscountPolicy;
import christmas.domain.policy.discount.SpecialDiscountPolicy;
import christmas.domain.policy.discount.WeekdayDiscountPolicy;
import christmas.domain.policy.discount.WeekendDiscountPolicy;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("DiscountPolicies 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DiscountPoliciesTest {

    @ParameterizedTest
    @MethodSource("주문_방문날짜_예상할인목록개수_제공")
    void 각_할인정책에_따라_주문에_대한_할인금액을_반환한다(String 주문, int 방문_날짜, int 예상_할인금액) {
        VisitDate visitDate = new VisitDate(방문_날짜);
        Orders orders = new Orders(주문);
        DiscountPolicies discountPolicies = new DiscountPolicies(할인종류_할인정책_생성());

        Discounts discounts = discountPolicies.createDiscounts(visitDate, orders);

        Assertions.assertEquals(discounts.sumDiscount(), 예상_할인금액);
    }

    private static Stream<Arguments> 주문_방문날짜_예상할인목록개수_제공() {
        return Stream.of(
                Arguments.of("티본스테이크-2,레드와인-1,초코케이크-2", 10, 6946),
                Arguments.of("티본스테이크-1,바비큐립-1,해산물파스타-1", 30, 6069),
                Arguments.of("시저샐러드-1,바비큐립-1,초코케이크-2,제로콜라-1", 1, 3023)
        );
    }

    private Map<DiscountType, DiscountPolicy> 할인종류_할인정책_생성() {
        EnumMap<DiscountType, DiscountPolicy> policy = new EnumMap<>(DiscountType.class);
        policy.put(CHRISTMAS_DDAY, new DdayDiscountPolicy());
        policy.put(SPECIAL, new SpecialDiscountPolicy());
        policy.put(WEEKDAY, new WeekdayDiscountPolicy());
        policy.put(WEEKEND, new WeekendDiscountPolicy());
        return policy;
    }
}
