package christmas.domain;

import static christmas.domain.MenuType.APPETIZER;
import static christmas.domain.MenuType.DESSERT;
import static christmas.domain.MenuType.DRINK;
import static christmas.domain.MenuType.MAIN;

import christmas.exception.InvalidOrderException;
import java.util.Arrays;

public enum Menu {
    MUSHROOM_SOUP("양송이수프", 6000, APPETIZER),
    TAPAS("타파스", 5500, APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, APPETIZER),

    T_BONE_STEAK("티본스테이크", 55000, MAIN),
    BBQ_RIBS("바비큐립", 54000, MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, MAIN),

    CHOCOLATE_CAKE("초코케이크", 15000, DESSERT),
    ICE_CREAM("아이스크림", 5000, DESSERT),

    ZERO_COLA("제로콜라", 3000, DRINK),
    RED_WINE("레드와인", 60000, DRINK),
    CHAMPAGNE("샴페인", 25000, DRINK);

    private final String name;
    private final int price;
    private final MenuType type;

    Menu(String menuName, int price, MenuType type) {
        this.name = menuName;
        this.price = price;
        this.type = type;
    }

    public static Menu from(String menuName) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menuName.equals(menu.name))
                .findFirst()
                .orElseThrow(InvalidOrderException::new);
    }

    public boolean isDrinkMenu() {
        return this.type == DRINK;
    }

    public boolean isDesertMenu() {
        return this.type == DESSERT;
    }

    public int calculatePrice(int quantity) {
        return this.price * quantity;
    }
}

