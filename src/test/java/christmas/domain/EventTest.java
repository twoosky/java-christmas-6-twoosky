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
import org.junit.jupiter.api.Test;

@DisplayName("Event 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class EventTest {

    /**
     * GIVEN 모든 이벤트를 생성한다.
     *       방문 날짜 및 주문을 입력받는다.
     * WHEN  각 이벤트에 대한 할인/증정 금액의 총합을 계산한다.
     * THEN  혜택 금액의 총합을 비교한다.
     */
    @Test
    void 모든_이벤트에_대한_혜택_금액_총합을_계산한다() {
        // given
        String 주문 = "티본스테이크-2,레드와인-1,초코케이크-2,제로콜라-1";
        VisitDate 방문_날짜 = new VisitDate(10);
        Orders 주문_목록 = new Orders(주문);
        Discounts 할인_목록 = new Discounts(할인정책에_따른_할인객체_리스트_생성());
        Gifts 증정_목록 = new Gifts(증정정책에_따른_증정객체_리스트_생성());
        이벤트_객체_생성(할인_목록, 증정_목록);

        // when
        int 혜택_금액_총합 = 이벤트_객체.혜택_금액_총합_계산();

        // then
        Assertions.assertEquals(혜택_금액_총합, 30_946);
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
