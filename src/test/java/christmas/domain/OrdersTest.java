package christmas.domain;

import static christmas.utils.ErrorMessages.INVALID_ORDER;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Orders 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class OrdersTest {

    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크--1,바비큐립1", "티본스테이크:1,바비큐립-2", "타파스-2초코케이크1"})
    void 메뉴형식이_다른_경우_예외를_던진다(String 잘못된_메뉴형식_입력) {
        Assertions.assertThatThrownBy(() -> new Orders(잘못된_메뉴형식_입력))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"시저샐러드-1,시저샐러드-2", "제로콜라-3,양송이수프-1,양송이수프-2"})
    void 중복메뉴를_입력한_경우_예외를_던진다(String 중복_주문_입력) {
        Assertions.assertThatThrownBy(() -> new Orders(중복_주문_입력))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"레드와인-1,제로콜라-2", "제로콜라-3"})
    void 음료만_주문한_경우_예외를_던진다(String 음료만_주문_입력) {
        Assertions.assertThatThrownBy(() -> new Orders(음료만_주문_입력))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER);
    }

    @Test
    void 초과_주문한_경우_예외를_던진다() {
        String 초과_주문_입력 = "시저샐러드-4,티본스테이크-4,크리스마스파스타-3,제로콜라-6,아이스크림-4";

        Assertions.assertThatThrownBy(() -> new Orders(초과_주문_입력))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER);
    }

    @Test
    void 총_주문금액을_계산한다() {
        // given
        String 주문 = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Orders orders = new Orders(주문);

        // when
        int 총_주문금액 = orders.총_주문금액_계산();

        // then
        assertEquals(총_주문금액, 142000);
    }
}
