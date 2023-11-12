package christmas.domain;

import static christmas.utils.ErrorMessages.INVALID_ORDER;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    void 메뉴판에_없는_메뉴를_주문한_경우_예외를_던진다() {
        // given
        String 입력한_메뉴 = "뇨끼";
        int 주문_개수 = 1;

        // when & then
        Assertions.assertThatThrownBy(() -> 주문_생성_요청(입력한_메뉴, 주문_개수))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER);
    }
}
