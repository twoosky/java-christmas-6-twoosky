package christmas.domain;

import static christmas.domain.DiscountType.CHRISTMAS_DDAY;
import static christmas.domain.DiscountType.SPECIAL;
import static christmas.domain.DiscountType.WEEKDAY;
import static christmas.domain.DiscountType.WEEKEND;
import static christmas.domain.GiftType.CHAMPAGNE;

import christmas.domain.policy.discount.DdayDiscountPolicy;
import christmas.domain.policy.discount.DiscountPolicy;
import christmas.domain.policy.discount.SpecialDiscountPolicy;
import christmas.domain.policy.discount.WeekdayDiscountPolicy;
import christmas.domain.policy.discount.WeekendDiscountPolicy;
import christmas.domain.policy.gift.GiftPolicy;
import christmas.domain.policy.gift.PriceGiftPolicy;
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

@DisplayName("GiftPolicies 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GiftPoliciesTest {

    @ParameterizedTest
    @MethodSource("주문_증정정책_예상증정가격_제공")
    void 증정_정책에_따라_증정_가격을_계산한다(String 주문, int 예상_증정_가격) {
        Orders orders = new Orders(주문);
        GiftPolicies giftPolicies = new GiftPolicies(증정종류_증정정책_생성());

        Gifts gifts = giftPolicies.createGifts(orders);

        Assertions.assertEquals(gifts.sumPrice(), 예상_증정_가격);
    }

    private static Stream<Arguments> 주문_증정정책_예상증정가격_제공() {
        return Stream.of(
                Arguments.of("티본스테이크-2,레드와인-1,초코케이크-2,제로콜라-1", 25000),
                Arguments.of("크리스마스파스타-1,시저샐러드-1,양송이수프-1,아이스크림-2", 0),
                Arguments.of("바비큐립-2,해산물파스타-1,제로콜라-3", 25000)
        );
    }

    private Map<GiftType, GiftPolicy> 증정종류_증정정책_생성() {
        EnumMap<GiftType, GiftPolicy> policy = new EnumMap<>(GiftType.class);
        policy.put(CHAMPAGNE, new PriceGiftPolicy());
        return policy;
    }
}
