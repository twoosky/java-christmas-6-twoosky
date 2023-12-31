package christmas.domain.policy;

import christmas.domain.Orders;
import christmas.domain.VisitDate;
import christmas.domain.policy.discount.DiscountPolicy;
import christmas.domain.policy.discount.SpecialDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("SpecialDiscountPolicy 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class SpecialDiscountPolicyTest {

    @ParameterizedTest
    @CsvSource(value = {"1:0", "3:1000", "31:1000", "25:1000"}, delimiter = ':')
    void 방문날짜가_일요일이거나_크리스마스인_경우_총주문_금액에서_1000원_할인한다(int 방문_날짜, int 예상_할인_금액) {
        String 주문 = "크리스마스파스타-2,제로콜라-2";
        VisitDate visitDate = new VisitDate(방문_날짜);
        Orders orders = new Orders(주문);
        DiscountPolicy discountPolicy = new SpecialDiscountPolicy();

        int 할인_금액 = discountPolicy.discount(visitDate, orders);

        Assertions.assertEquals(할인_금액, 예상_할인_금액);
    }
}
