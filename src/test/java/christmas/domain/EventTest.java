package christmas.domain;

import static christmas.domain.DiscountType.CHRISTMAS_DDAY;
import static christmas.domain.DiscountType.SPECIAL;
import static christmas.domain.DiscountType.WEEKDAY;
import static christmas.domain.DiscountType.WEEKEND;
import static christmas.domain.GiftType.CHAMPAGNE;

import christmas.domain.policy.discount.DdayDiscountPolicy;
import christmas.domain.policy.discount.SpecialDiscountPolicy;
import christmas.domain.policy.discount.WeekdayDiscountPolicy;
import christmas.domain.policy.discount.WeekendDiscountPolicy;
import christmas.domain.policy.gift.PriceGiftPolicy;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Event 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class EventTest {

    @ParameterizedTest
    @CsvSource(value = {"티본스테이크-2,레드와인-1,초코케이크-2:10:31946", "티본스테이크-1,바비큐립-1,해산물파스타-1:30:31069"}, delimiter = ':')
    void 모든_이벤트에_대한_혜택_금액_총합을_계산한다(String 주문, int 방문_날짜, int 에상_혜택금액_총합) {
        VisitDate visitDate = new VisitDate(방문_날짜);
        Orders orders = new Orders(주문);
        Discounts discounts = new Discounts(할인정책에_따른_할인객체_리스트_생성());
        Gifts gifts = new Gifts(증정정책에_따른_증정객체_리스트_생성());
        Event event = new Event(discounts, gifts);

        int 혜택금액_총합 = event.getTotalBenefit(visitDate, orders);

        Assertions.assertEquals(혜택금액_총합, 에상_혜택금액_총합);
    }

    @ParameterizedTest
    @CsvSource(value = {"티본스테이크-2,레드와인-1,초코케이크-2:10:6946", "티본스테이크-1,바비큐립-1,해산물파스타-1:30:6069"}, delimiter = ':')
    void 할인_이벤트에_대한_할인_금액_합계를_계산한다(String 주문, int 방문_날짜, int 에상_혜택금액_총합) {
        VisitDate visitDate = new VisitDate(방문_날짜);
        Orders orders = new Orders(주문);
        Discounts discounts = new Discounts(할인정책에_따른_할인객체_리스트_생성());
        Gifts gifts = new Gifts(증정정책에_따른_증정객체_리스트_생성());
        Event event = new Event(discounts, gifts);

        int 혜택금액_총합 = event.getTotalDiscount(visitDate, orders);

        Assertions.assertEquals(혜택금액_총합, 에상_혜택금액_총합);
    }

    private List<Discount> 할인정책에_따른_할인객체_리스트_생성() {
        return List.of(
                new Discount(CHRISTMAS_DDAY, new DdayDiscountPolicy()),
                new Discount(SPECIAL, new SpecialDiscountPolicy()),
                new Discount(WEEKDAY, new WeekdayDiscountPolicy()),
                new Discount(WEEKEND, new WeekendDiscountPolicy())
        );
    }

    private static List<Gift> 증정정책에_따른_증정객체_리스트_생성() {
        return List.of(
                new Gift(CHAMPAGNE, new PriceGiftPolicy())
        );
    }
}
