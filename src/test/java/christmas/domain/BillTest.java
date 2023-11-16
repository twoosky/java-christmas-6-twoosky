package christmas.domain;

import static christmas.domain.DiscountType.CHRISTMAS_DDAY;
import static christmas.domain.DiscountType.SPECIAL;
import static christmas.domain.DiscountType.WEEKDAY;
import static christmas.domain.DiscountType.WEEKEND;
import static christmas.domain.GiftType.CHAMPAGNE;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Event 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BillTest {
    private static Bill bill;

    @BeforeEach
    void setUp() {
        Discounts discounts = new Discounts(할인객체_리스트_생성());
        Gifts gifts = new Gifts(증정객체_리스트_생성());
        bill = new Bill(discounts, gifts);
    }

    private List<Discount> 할인객체_리스트_생성() {
        return List.of(
                new Discount(CHRISTMAS_DDAY, 3400),
                new Discount(SPECIAL, 1000),
                new Discount(WEEKDAY, 4046),
                new Discount(WEEKEND, 0)
        );
    }

    private static List<Gift> 증정객체_리스트_생성() {
        return List.of(
                new Gift(CHAMPAGNE, 1)
        );
    }

    @Test
    void 모든_이벤트에_대한_혜택_금액_총합을_계산한다() {
        String 주문 = "티본스테이크-2,레드와인-1,초코케이크-2,제로콜라-1";
        Orders orders = new Orders(주문);

        int 혜택금액_총합 = bill.getTotalBenefit(orders);

        Assertions.assertEquals(혜택금액_총합, 33_446);
    }

    @Test
    void 할인_후_예상_결제금액을_계산한다() {
        String 주문 = "티본스테이크-2,레드와인-1,초코케이크-2,제로콜라-1";
        Orders orders = new Orders(주문);

        int 혜택금액_총합 = bill.getDiscountPrice(orders);

        Assertions.assertEquals(혜택금액_총합, 194_554);
    }

    @ParameterizedTest
    @ValueSource(strings = {"타파스-1,제로콜라-1", "제로콜라-1,아이스크림-1", "시저샐러드-1"})
    void 총_주문금액이_10000원보다_작으면_혜택_금액으로_0을_반환한다(String 주문) {
        Orders orders = new Orders(주문);

        int 혜택금액_총합 = bill.getTotalBenefit(orders);

        Assertions.assertEquals(혜택금액_총합, 0);
    }
}
