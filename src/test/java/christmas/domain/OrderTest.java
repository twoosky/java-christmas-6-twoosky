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

    @ParameterizedTest
    @CsvSource(value = {"바비큐립:3:162000", "해산물파스타:2:70000", "시저샐러드:1:8000"}, delimiter = ':')
    void 주문금액을_계산한다(String 메뉴, String 주문_개수, int 예상_주문금액) {
        Order order = new Order(메뉴, 주문_개수);

        int 주문금액 = order.calculatePrice();

        assertEquals(주문금액, 예상_주문금액);
    }

    @ParameterizedTest
    @MethodSource("주문메뉴_주문개수_메뉴타입_예상일치여부_제공")
    void 메뉴_타입에_따른_주문_일치여부를_반환한다(String 주문_메뉴, String 주문_개수, MenuType 메뉴_타입, boolean 예상_일치_여부) {
        Order order = new Order(주문_메뉴, 주문_개수);

        boolean 일치_여부 = order.isEqualsMenuType(메뉴_타입);

        assertEquals(일치_여부, 예상_일치_여부);
    }

    private static Stream<Arguments> 주문메뉴_주문개수_메뉴타입_예상일치여부_제공() {
        return Stream.of(
                Arguments.of("초코케이크", "1", MenuType.DESSERT, true),
                Arguments.of("티본스테이크", "1", MenuType.MAIN, true),
                Arguments.of("제로콜라", "1", MenuType.DRINK, true),
                Arguments.of("양송이수프", "1", MenuType.MAIN, false)
        );
    }
}
