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
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Discount 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DiscountTest {

    @ParameterizedTest
    @MethodSource("할인종류_할인정책_할인금액_제공")
    void 할인금액을_반환한다(DiscountType 할인_종류, DiscountPolicy 할인_정책, int 예상_할인_금액) {
        Discount discount = new Discount(할인_종류, 1000);

        int 할인_금액 = discount.getAmount();

        Assertions.assertEquals(할인_금액, 1000);
    }

    private static Stream<Arguments> 할인종류_할인정책_할인금액_제공() {
        return Stream.of(
                Arguments.of(CHRISTMAS_DDAY, new DdayDiscountPolicy(), 1900),
                Arguments.of(SPECIAL, new SpecialDiscountPolicy(), 1000),
                Arguments.of(WEEKDAY, new WeekdayDiscountPolicy(), 4046),
                Arguments.of(WEEKEND, new WeekendDiscountPolicy(), 0)
        );
    }
}
