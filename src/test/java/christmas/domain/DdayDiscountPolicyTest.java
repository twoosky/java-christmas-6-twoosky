package christmas.domain;

import christmas.domain.policy.discount.DdayDiscountPolicy;
import christmas.domain.policy.discount.DiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("DdayDiscountPolicy 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DdayDiscountPolicyTest {

    /**
     * GIVEN 크리스마스 당일에 방문한다.
     * WHEN  크리스마스 디데이 할인 금액을 계산한다.
     * THEN  3400원 할인된다.
     */
    @ParameterizedTest
    @CsvSource(value = {"25:3400", "1:1000", "15:2400"}, delimiter = ':')
    void 크리스마스_디데이만큼_100원씩_추가_할인한다(int 방문_날짜, int 예상_할인_금액) {
        String 주문 = "티본스테이크-2,레드와인-1,초코케이크-2";
        VisitDate visitDate = new VisitDate(방문_날짜);
        Orders orders = new Orders(주문);
        DiscountPolicy discountPolicy = new DdayDiscountPolicy();

        int 할인_금액 = discountPolicy.discount(visitDate, orders);

        Assertions.assertEquals(할인_금액, 예상_할인_금액);
    }

    @ParameterizedTest
    @CsvSource(value = {"31:0", "26:0"}, delimiter = ':')
    void 크리스마스_이후에_방문하는_경우_할인하지_않는다(int 방문_날짜, int 예상_할인_금액) {
        String 주문 = "티본스테이크-2,레드와인-1,초코케이크-2";
        VisitDate visitDate = new VisitDate(방문_날짜);
        Orders orders = new Orders(주문);
        DiscountPolicy discountPolicy = new DdayDiscountPolicy();

        int 할인_금액 = discountPolicy.discount(visitDate, orders);

        Assertions.assertEquals(할인_금액, 예상_할인_금액);
    }
}
