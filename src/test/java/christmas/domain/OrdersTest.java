package christmas.domain;

import static christmas.utils.ErrorMessages.INVALID_ORDER;

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
    @ValueSource(strings = {"티본스테이크--1,바비큐립1", "티본스테이크:1,바비큐립-2"})
    void 메뉴형식이_다른_경우_예외를_던진다(String inputOrders) {
        Assertions.assertThatThrownBy(() -> new Orders(inputOrders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER);
    }

    @Test
    void 중복메뉴를_입력한_경우_예외를_던진다() {
        // given
        String 중복_주문_입력 = "시저샐러드-1,시저샐러드-2";

        // when & then
        Assertions.assertThatThrownBy(() -> new Orders(중복_주문_입력))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER);
    }

    @Test
    void 음료만_주문한_경우_예외를_던진다() {
        // given
        String 음료_주문_입력 = "제로콜라-2,레드와인-1";

        // when & then
        Assertions.assertThatThrownBy(() -> new Orders(음료_주문_입력))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER);
    }

    @Test
    void 초과_주문한_경우_예외를_던진다() {
        // given
        String 초과_주문_입력 = "시저샐러드-4,티본스테이크-4,크리스마스파스타-3,제로콜라-6,아이스크림-4";

        // when & then
        Assertions.assertThatThrownBy(() -> new Orders(초과_주문_입력))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER);
    }
}
