package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Menu Enum")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class MenuTest {

    @ParameterizedTest
    @MethodSource("메뉴종류_메뉴타입_예상일치여부_제공")
    void 메뉴타입에_대한_메뉴_일치여부를_반환한다(Menu 메뉴_종류, MenuType 메뉴_타입, boolean 에상_일치_여부) {
        boolean 일치_여부 = 메뉴_종류.isEqualsMenuType(메뉴_타입);
        assertEquals(일치_여부, 에상_일치_여부);
    }

    private static Stream<Arguments> 메뉴종류_메뉴타입_예상일치여부_제공() {
        return Stream.of(
                Arguments.of(Menu.BBQ_RIBS, MenuType.DESSERT, false),
                Arguments.of(Menu.CHRISTMAS_PASTA, MenuType.MAIN, true),
                Arguments.of(Menu.RED_WINE, MenuType.DRINK, true),
                Arguments.of(Menu.CAESAR_SALAD, MenuType.MAIN, false)
        );
    }
}
