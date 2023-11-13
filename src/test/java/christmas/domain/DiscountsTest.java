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
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Discounts 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DiscountsTest {

    /**
     * GIVEN 방문 날짜와 주문을 입력한다.
     *       할인 정책에 따른 할인 객체 리스트를 생성한다.
     * WHEN  각 할인 정책의 할인 금액을 합한다.
     * THEN  할인 정책의 총합을 비교한다.
     */

    void 할인금액의_총합을_계산한다() {
        // given
        String 주문 = "티본스테이크-2,레드와인-1,초코케이크-2,제로콜라-1";
        VisitDate 방문_날짜 = new VisitDate(10);
        Orders 주문_목록 = new Orders(주문);

        // when
        int 할인_금액 = 할인_객체.할인(방문_날짜, 주문_목록);

        // then
        Assertions.assertEquals(할인_금액, 4046);
    }

    private static List<Discount> 할인정책에_따른_할인객체_리스트_생성 () {
        return List.of(
                new Discount(CHRISTMAS_DDAY, new DdayDiscountPolicy()),
                new Discount(SPECIAL, new SpecialDiscountPolicy()),
                new Discount(WEEKDAY, new WeekdayDiscountPolicy()),
                new Discount(WEEKEND, new WeekendDiscountPolicy())
        );
    }
}
