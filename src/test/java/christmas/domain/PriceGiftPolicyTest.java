package christmas.domain;

import christmas.domain.policy.GiftPolicy;
import christmas.domain.policy.PriceGiftPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
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

        GiftType 증정품 = giftPolicy.give(orders);

        Assertions.assertEquals(증정품, GiftType.CHAMPAGNE);
    }
}
