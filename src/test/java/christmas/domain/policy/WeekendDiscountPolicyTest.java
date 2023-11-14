package christmas.domain.policy;


import christmas.domain.Orders;
import christmas.domain.VisitDate;
import christmas.domain.policy.discount.DiscountPolicy;
import christmas.domain.policy.discount.WeekendDiscountPolicy;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("WeekendDiscountPolicy 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class WeekendDiscountPolicyTest {

    @ParameterizedTest
    @MethodSource("주문_방문날짜_예상할인금액_제공")
    void 금요일_토요일에_메인메뉴를_개당_2023원_할인한다(String 주문, int 방문_날짜, int 예상_할인금액) {
        VisitDate visitDate = new VisitDate(방문_날짜);
        Orders orders = new Orders(주문);
        DiscountPolicy discountPolicy = new WeekendDiscountPolicy();

        int 할인_금액 = discountPolicy.discount(visitDate, orders);

        Assertions.assertEquals(할인_금액, 예상_할인금액);
    }

    private static Stream<Arguments> 주문_방문날짜_예상할인금액_제공() {
        return Stream.of(
                Arguments.of("해산물파스타-2,레드와인-1,초코케이크-2", 1, 4046),
                Arguments.of("바비큐립-1,아이스크림-1,초코케이크-1", 23, 2023),
                Arguments.of("시저샐러드-3,제로콜라-3", 30, 0)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"양송이수프-3,시저샐러드-1:15:0", "타파스-3,샴페인-1:15:0"}, delimiter = ':')
    void 메인_메뉴를_주문하지_않은_경우_할인하지_않는다(String 메인없이_주문, int 방문_날짜, int 예상_할인금액) {
        VisitDate visitDate = new VisitDate(방문_날짜);
        Orders orders = new Orders(메인없이_주문);
        DiscountPolicy discountPolicy = new WeekendDiscountPolicy();

        int 할인_금액 = discountPolicy.discount(visitDate, orders);

        Assertions.assertEquals(할인_금액, 예상_할인금액);
    }
}
