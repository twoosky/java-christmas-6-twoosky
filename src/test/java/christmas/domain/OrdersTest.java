package christmas.domain;

import static christmas.utils.ErrorMessages.INVALID_ORDER;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Orders 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class OrdersTest {


    @Test
    void 메뉴형식이_다른_경우_예외를_던진다() {
        // given
        String 주문_메뉴 = "티본스테이크--1,바비큐립1";

        // when & then
        Assertions.assertThatThrownBy(() -> new 메뉴_주문_생성_요청(주문_메뉴))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER);
    }
}
