package christmas.domain;

import christmas.domain.policy.WeekdayDiscountPolicy;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("WeekdayDiscountPolicy 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class WeekdayDiscountPolicyTest {

    @ParameterizedTest
    @MethodSource("주문_방문날짜_예상할인금액_제공")
    void 월요일부터_목요일에_디저트메뉴를_개당_2023원_할인한다(String 주문, int 방문_날짜, int 예상_할인금액) {
        VisitDate visitDate = new VisitDate(방문_날짜);
        Orders orders = new Orders(주문);
        WeekdayDiscountPolicy weekdayDiscountPolicy = new WeekdayDiscountPolicy();

        int 할인_금액 = weekdayDiscountPolicy.discount(visitDate, orders);

        Assertions.assertEquals(할인_금액, 예상_할인금액);
    }

    private static Stream<Arguments> 주문_방문날짜_예상할인금액_제공() {
        return Stream.of(
                Arguments.of("해산물파스타-2,레드와인-1,초코케이크-2", 17, 4046),
                Arguments.of("바비큐립-1,아이스크림-1,초코케이크-1", 28, 4046),
                Arguments.of("크리스마스파스타-2,레드와인-1,초코케이크-1", 23, 0)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"해산물파스타-2,시저샐러드-1:3:0", "바비큐립-1,샴페인-1:25:0"}, delimiter = ':')
    void 디저트_메뉴를_주문하지_않은_경우_할인하지_않는다(String 디저트없이_주문, int 주말_방문_날짜, int 예상_할인금액) {
        VisitDate visitDate = new VisitDate(주말_방문_날짜);
        Orders orders = new Orders(디저트없이_주문);
        WeekdayDiscountPolicy weekdayDiscountPolicy = new WeekdayDiscountPolicy();

        int 할인_금액 = weekdayDiscountPolicy.discount(visitDate, orders);

        Assertions.assertEquals(할인_금액, 예상_할인금액);
    }
}
