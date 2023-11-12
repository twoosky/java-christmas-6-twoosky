package christmas.domain;

import static christmas.utils.ErrorMessages.INVALID_ORDER;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

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

    @Test
    void 메뉴의_주문개수가_숫자가_아닌_경우_예외를_던진다() {
        // given
        String 입력_메뉴 = "곱창";
        String 주문_개수 = "a";

        // when & then
        Assertions.assertThatThrownBy(() -> new Order(입력_메뉴, 주문_개수))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER);
    }
}
