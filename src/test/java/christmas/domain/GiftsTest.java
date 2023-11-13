package christmas.domain;

import static christmas.domain.GiftType.CHAMPAGNE;

import christmas.domain.policy.gift.GiftPolicy;
import christmas.domain.policy.gift.PriceGiftPolicy;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Gifts 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GiftsTest {

    /**
     * GIVEN 방문 날짜와 주문을 입력한다.
     *       증정 정책에 따른 증정 객체 리스트를 생성한다.
     * WHEN  각 증정 정책의 증정품 가격을 합한다.
     * THEN  증정품 가격의 총합을 비교한다.
     */
    @Test
    void 총_증정_금액을_계산한다() {
        // given
        String 주문 = "티본스테이크-2,레드와인-1,초코케이크-2,제로콜라-1";
        Orders 주문_목록 = new Orders(주문);
        List<Gift> 증정_목록 = 증정정책에_따른_증정객체_리스트_생성();
        증정_목록_객체_생성(증정_목록);

        // when
        int 증정금액_총합 = 증정_목록_객체.총합_계산(주문_목록);

        // then
        Assertions.assertEquals(증정금액_총합, 25000);
    }

    private static List<Gift> 증정정책에_따른_증정객체_리스트_생성() {
        return List.of(
                new Gift(CHAMPAGNE, new PriceGiftPolicy())
        );
    }
}
