package christmas.domain;

import static christmas.exception.ErrorMessages.INVALID_ORDER;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
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

    @ParameterizedTest
    @CsvSource(value = {"티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1:142000", "해산물파스타-2,레드와인-1:130000"}, delimiter = ':')
    void 총_주문금액을_계산한다(String 주문, int 예상_총_주문금액) {
        Orders orders = new Orders(주문);

        int 총_주문금액 = orders.getTotalPrice();

        assertEquals(총_주문금액, 예상_총_주문금액);
    }

    @ParameterizedTest
    @MethodSource("주문_메뉴타입_예상주문개수_제공")
    void 메뉴타입과_일치하는_주문의_총_개수를_계산한다(String 주문, MenuType 메뉴_타입, int 예상_주문개수) {
        Orders orders = new Orders(주문);

        int 주문개수 = orders.getQuantityByMenuType(메뉴_타입);

        assertEquals(주문개수, 예상_주문개수);
    }

    private static Stream<Arguments> 주문_메뉴타입_예상주문개수_제공() {
        return Stream.of(
                Arguments.of("티본스테이크-1,초코케이크-2,레드와인-1", MenuType.DESSERT, 2),
                Arguments.of("크리스마스파스타-2,제로콜라-2", MenuType.MAIN, 2),
                Arguments.of("시저샐러드-4,티본스테이크-4,아이스크림-3", MenuType.DRINK, 0)
        );
    }
}
