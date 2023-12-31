package christmas.domain.policy;

import christmas.domain.Orders;
import christmas.domain.policy.gift.GiftPolicy;
import christmas.domain.policy.gift.PriceGiftPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("PriceGiftPolicy 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PriceGiftPolicyTest {

    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-2,시저샐러드-2", "시저샐러드-1,바비큐립-2,크리스마스파스타-2,제로콜라-3"})
    void 할인_전_총주문_금액이_12만원_이상이면_증정품을_제공한다(String 주문) {
        Orders orders = new Orders(주문);
        GiftPolicy giftPolicy = new PriceGiftPolicy();

        int 증정_개수 = giftPolicy.calculateGiftQuantity(orders);

        Assertions.assertEquals(증정_개수, 1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-1,시저샐러드-2", "시저샐러드-1,바비큐립-1,제로콜라-2"})
    void 할인_전_총주문_금액이_12만원_미만이면_증정품을_제공하지_않는다(String 주문) {
        Orders orders = new Orders(주문);
        GiftPolicy giftPolicy = new PriceGiftPolicy();

        int 증정_개수 = giftPolicy.calculateGiftQuantity(orders);

        Assertions.assertEquals(증정_개수, 0);
    }
}
