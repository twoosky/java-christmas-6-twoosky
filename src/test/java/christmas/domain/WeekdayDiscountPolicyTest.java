package christmas.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("WeekdayDiscountPolicy 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class WeekdayDiscountPolicyTest {

    @Test
    void 월요일부터_목요일에_디저트메뉴를_개당_2023원_할인한다() {
        // given
        String 주문 = "해산물파스타-2,레드와인-1,초코케이크-2";
        VisitDate 방문_날짜 = new VisitDate(17);
        Orders 주문_목록 = new Orders(주문);

        // when
        int 할인_금액 = 평일_할인_정책.할인(방문_날짜, 주문_목록);

        // then
        Assertions.assertEquals(할인_금액, 4046);
    }
}
