package christmas.domain;

import static christmas.utils.ErrorMessages.INVALID_ORDER;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
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
}
