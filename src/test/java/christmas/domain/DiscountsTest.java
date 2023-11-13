package christmas.domain;

import static christmas.domain.DiscountType.CHRISTMAS_DDAY;
import static christmas.domain.DiscountType.SPECIAL;
import static christmas.domain.DiscountType.WEEKDAY;
import static christmas.domain.DiscountType.WEEKEND;

import christmas.domain.policy.discount.DdayDiscountPolicy;
import christmas.domain.policy.discount.SpecialDiscountPolicy;
import christmas.domain.policy.discount.WeekdayDiscountPolicy;
import christmas.domain.policy.discount.WeekendDiscountPolicy;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Discounts 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DiscountsTest {

    @ParameterizedTest
    @CsvSource(value = {"10:6946", "23:7246", "31:5046"}, delimiter = ':')
    void 할인금액의_총합을_계산한다(int 방문_날짜, int 예상_할인금액_총합) {
        String 주문 = "티본스테이크-2,레드와인-1,초코케이크-2,제로콜라-1";
        VisitDate visitDate = new VisitDate(방문_날짜);
        Orders orders = new Orders(주문);
        Discounts discounts = new Discounts(할인정책에_따른_할인객체_리스트_생성());

        int 할인금액_총합 = discounts.calculateTotalDiscount(visitDate, orders);

        Assertions.assertEquals(할인금액_총합, 예상_할인금액_총합);
    }

    @ParameterizedTest
    @ValueSource(strings = {"타파스-1,제로콜라-1", "제로콜라-1,아이스크림-1", "시저샐러드-1"})
    void 총_주문금액이_10000원보다_작으면_할인하지_않는다(String 주문) {
        VisitDate visitDate = new VisitDate(1);
        Orders orders = new Orders(주문);
        Discounts discounts = new Discounts(할인정책에_따른_할인객체_리스트_생성());

        int 할인금액_총합 = discounts.calculateTotalDiscount(visitDate, orders);

        Assertions.assertEquals(할인금액_총합, 0);
    }

    private List<Discount> 할인정책에_따른_할인객체_리스트_생성() {
        return List.of(
                new Discount(CHRISTMAS_DDAY, new DdayDiscountPolicy()),
                new Discount(SPECIAL, new SpecialDiscountPolicy()),
                new Discount(WEEKDAY, new WeekdayDiscountPolicy()),
                new Discount(WEEKEND, new WeekendDiscountPolicy())
        );
    }
}
