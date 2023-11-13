package christmas.domain;

import static christmas.domain.GiftType.CHAMPAGNE;
import static christmas.domain.GiftType.NONE;

import christmas.domain.policy.gift.GiftPolicy;
import christmas.domain.policy.gift.PriceGiftPolicy;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Gift 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GiftTest {

    @ParameterizedTest
    @MethodSource("주문_증정정책_예상증정품_제공")
    void 각_이벤트_증정_정책에_따라_증정품을_제공한다(String 주문, GiftType 예상_증정품) {
        Orders orders = new Orders(주문);
        GiftPolicy giftPolicy = new PriceGiftPolicy();
        Gift gift = new Gift(CHAMPAGNE, giftPolicy);

        GiftType 증정품 = gift.give(orders);

        Assertions.assertEquals(증정품, 예상_증정품);
    }

    private static Stream<Arguments> 주문_증정정책_예상증정품_제공() {
        return Stream.of(
                Arguments.of("티본스테이크-2,레드와인-1,초코케이크-2,제로콜라-1", CHAMPAGNE),
                Arguments.of("크리스마스파스타-1,시저샐러드-1,양송이수프-1,아이스크림-2", NONE),
                Arguments.of("바비큐립-2,해산물파스타-1,제로콜라-3", CHAMPAGNE)
        );
    }
}
