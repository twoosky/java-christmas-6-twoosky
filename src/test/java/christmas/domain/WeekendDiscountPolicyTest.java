package christmas.domain;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("WeekendDiscountPolicy 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class WeekendDiscountPolicyTest {

    /**
     * GIVEN 토요일에 방문한다. 메인메뉴가 포함된 메뉴를 주문한다.
     * WHEN  주말 할인 금액을 계산한다.
     * THEN  메인 메뉴 개수만큼 할인 금액이 계산된다.
     */
    @Test
    void 금요일_토요일에_메인메뉴를_개당_2023원_할인한다() {
        // given
        String 주문 = "티본스테이크-2,레드와인-1,초코케이크-2";
        VisitDate 방문_날짜 = new VisitDate(23);
        Orders 주문_목록 = new Orders(주문);

        // when
        int 할인_금액 = 주말_할인정책.할인(방문 날짜, 주문_목록);

        // then
        Assertions.assertEquals(할인_금액, 4046);
    }
}
