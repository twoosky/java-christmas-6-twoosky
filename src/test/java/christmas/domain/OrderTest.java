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

@DisplayName("Order 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class OrderTest {

    @Test
    void 메뉴판에_없는_메뉴를_주문한_경우_예외를_던진다() {
        String inputMenu = "곱창";
        String orderQuantity = "1";

        Assertions.assertThatThrownBy(() -> new Order(inputMenu, orderQuantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "ab!", "a1%^*"})
    void 메뉴의_주문개수가_숫자가_아닌_경우_예외를_던진다(String orderQuantity) {
        String inputManu = "시저샐러드";

        Assertions.assertThatThrownBy(() -> new Order(inputManu, orderQuantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-10", "0"})
    void 메뉴_주문개수가_1보다_작은_경우_예외를_던진다(String orderQuantity) {
        String inputMenu = "크리스마스파스타";

        Assertions.assertThatThrownBy(() -> new Order(inputMenu, orderQuantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER);
    }

    @Test
    void 주문금액을_계산한다() {
        // given
        String 메뉴 = "바비큐립";
        String 주문_개수 = "3";
        Order 주문 = new Order(메뉴, 주문_개수);

        // when
        int 주문금액 = 주문.주문금액_계산();

        // then
        assertEquals(주문금액, 162000);
    }
}
