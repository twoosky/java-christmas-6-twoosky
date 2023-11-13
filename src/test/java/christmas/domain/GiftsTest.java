package christmas.domain;

import static christmas.domain.GiftType.CHAMPAGNE;

import christmas.domain.policy.gift.PriceGiftPolicy;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Gifts 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GiftsTest {

    @ParameterizedTest
    @CsvSource(value= {"티본스테이크-2,시저샐러드-2:25000", "티본스테이크-1,시저샐러드-2:0"}, delimiter = ':')
    void 총_증정_금액을_계산한다(String 주문, int 예상_증정금액_총합) {
        Orders orders = new Orders(주문);
        Gifts gifts = new Gifts(증정정책에_따른_증정객체_리스트_생성());

        int 증정금액_총합 = gifts.calculateTotalPrice(orders);

        Assertions.assertEquals(증정금액_총합, 예상_증정금액_총합);
    }

    private static List<Gift> 증정정책에_따른_증정객체_리스트_생성() {
        return List.of(
                new Gift(CHAMPAGNE, new PriceGiftPolicy())
        );
    }
}
