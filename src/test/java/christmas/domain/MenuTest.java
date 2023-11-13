package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@DisplayName("Menu 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class MenuTest {

    @ParameterizedTest
    @EnumSource(value = Menu.class, names = {"ZERO_COLA", "RED_WINE", "CHAMPAGNE"})
    void 음료_메뉴이면_true를_반환한다(Menu menu) {
        boolean 음료_메뉴_여부 = menu.isDrinkMenu();
        assertEquals(음료_메뉴_여부, true);
    }

    @ParameterizedTest
    @EnumSource(value = Menu.class, names = {"MUSHROOM_SOUP", "T_BONE_STEAK", "CHOCOLATE_CAKE"})
    void 음료_메뉴가_아니면_false를_반환한다(Menu menu) {
        boolean 음료_메뉴_여부 = menu.isDrinkMenu();
        assertEquals(음료_메뉴_여부, false);
    }

    @ParameterizedTest
    @EnumSource(value = Menu.class, names = {"CHOCOLATE_CAKE", "ICE_CREAM"})
    void 디저트_메뉴이면_true를_반환한다(Menu menu) {
        boolean 디저트_메뉴_여부 = menu.isDesertMenu();
        assertEquals(디저트_메뉴_여부, true);
    }

    @ParameterizedTest
    @EnumSource(value = Menu.class, names = {"MUSHROOM_SOUP", "T_BONE_STEAK", "CHAMPAGNE"})
    void 디저트_메뉴가_아니면_false를_반환한다(Menu menu) {
        boolean 디저트_메뉴_여부 = menu.isDesertMenu();
        assertEquals(디저트_메뉴_여부, false);
    }
}
