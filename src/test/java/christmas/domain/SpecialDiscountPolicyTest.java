package christmas.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpecialDiscountPolicyTest {

    /**
     * GIVEN 크리스마스에 방문한다.
     * WHEN  특별 할인 금액을 계산한다.
     * THEN  1000원 할인받는다.
     */
    @Test
    void 방문날짜가_일요일이거나_크리스마스인_경우_총주문_금액에서_1000원_할인한다() {
        // given
        String 주문 = "크리스마스파스타-2,코카콜라-2";
        VisitDate 방문_날짜 = new VisitDate(25);
        Orders 주문_목록 = new Orders(주문);

        // when
        int 할인_금액 = 특별_할인_정책.할인(방문_날짜, 주문_목록);

        // then
        Assertions.assertEquals(할인_금액, 1000);
    }
}
