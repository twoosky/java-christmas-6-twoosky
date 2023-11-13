package christmas.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("DdayDiscountPolicy 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DdayDiscountPolicyTest {

    /**
     * GIVEN 크리스마스 당일에 방문한다.
     * WHEN  크리스마스 디데이 할인 금액을 계산한다.
     * THEN  3400원 할인된다.
     */
    @Test
    void 크리스마스_디데이만큼_100원씩_추가할인한다() {
        // given
        String 주문 = "티본스테이크-2,레드와인-1,초코케이크-2";
        VisitDate 방문_날짜 = new VisitDate(25);
        Orders 주문_목록 = new Orders(주문);

        // when
        int 할인_금액 = 크리스마스_디데이_할인정책.할인(방문_날짜, 주문_목록);

        // then
        Assertions.assertEquals(할인_금액, 3400);
    }

    /**
     * GIVEN 크리스마스 이후 방문한다.
     * WHEN  크리스마스 디데이 할인 금액을 계산한다.
     * THEN  0원 할인된다.
     */
    @Test
    void 크리스마스_이후_방문한_경우_할인되지_않는다() {
        // given
        String 주문 = "티본스테이크-2,레드와인-1,초코케이크-2";
        VisitDate 방문_날짜 = new VisitDate(31);
        Orders 주문_목록 = new Orders(주문);

        // when
        int 할인_금액 = 크리스마스_디데이_할인정책.할인(방문_날짜, 주문_목록);

        // then
        Assertions.assertEquals(할인_금액, 3400);
    }
}
