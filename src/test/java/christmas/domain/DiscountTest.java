package christmas.domain;

import christmas.domain.policy.DdayDiscountPolicy;
import christmas.domain.policy.DiscountPolicy;
import christmas.domain.policy.SpecialDiscountPolicy;
import christmas.domain.policy.WeekdayDiscountPolicy;
import christmas.domain.policy.WeekendDiscountPolicy;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Discount 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DiscountTest {

    /**
     * GIVEN 방문 날짜 및 주문을 입력한다.
     * WHEN  할인 정책에 따라 할인 금액을 계산한다.
     * THEN  할인 정책에 따라 할인된다.
     */
    @ParameterizedTest
    @MethodSource("할인종류_할인정책_할인금액_제공")
    void 각_할인정책에_따라_주문에_대한_할인금액을_반환한다(Enum 할인_종류, DiscountPolicy 할인_정책, int 예상_할인_금액) {
        // given
        String 주문 = "티본스테이크-2,레드와인-1,초코케이크-2,제로콜라-1";
        VisitDate 방문_날짜 = new VisitDate(10);
        Orders 주문_목록 = new Orders(주문);

        // when
        int 할인_금액 = 할인_객체.할인(방문_날짜, 주문_목록);

        // then
        Assertions.assertEquals(할인_금액, 예상_할인_금액);
    }

    private static Stream<Arguments> 할인종류_할인정책_할인금액_제공() {
        return Stream.of(
                Arguments.of("크리스마스 디데이 할인", new DdayDiscountPolicy(), 1900),
                Arguments.of("특별 할인", new SpecialDiscountPolicy(), 1000),
                Arguments.of("평일 할인", new WeekdayDiscountPolicy(), 4046),
                Arguments.of("주말 할인", new WeekendDiscountPolicy(), 0)
        );
    }
}
