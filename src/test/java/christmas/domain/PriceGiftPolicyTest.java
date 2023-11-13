package christmas.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("PriceGiftPolicy 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PriceGiftPolicyTest {

    /**
     * GIVEN 티본스테이크(55,000) 2개와 시저샐러드(8,000) 2개를 주문한다.
     * WHEN  가격에 대한 증정품 제공 여부를 계산한다.
     * THEN  증정품을 제공한다.
     */
    @Test
    void 할인_전_총주문_금액이_12만원_이상이면_증정품을_제공한다() {
        // given
        String 주문 = "티본스테이크-2,시저샐러드-2";
        Orders 주문_목록 = new Orders(주문);

        // when
        증정품_종류 증정품 = 가격에_대한_증정품_정책.증정품_제공(주문_목록);

        // then
        Assertions.assertEquals(증정품_종류, 샴페인);
    }
}
