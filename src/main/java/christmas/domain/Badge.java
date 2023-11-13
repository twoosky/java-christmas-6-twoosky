package christmas.domain;

import static christmas.exception.ErrorMessages.NOT_EXISTS_BADGE;

import java.util.Arrays;

public enum Badge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000),
    NONE("없음", 0),
    ;

    private final String name;
    private final int minimumAmount;

    private Badge(String name, int minimumAmount) {
        this.name = name;
        this.minimumAmount = minimumAmount;
    }

    public static String getNameByBenefitAmount(int amount) {
        return from(amount).name;
    }

    public static Badge from(int amount) {
        return Arrays.stream(Badge.values())
                .filter(badge -> badge.isGreaterThan(amount))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(NOT_EXISTS_BADGE));
    }

    private boolean isGreaterThan(int benefitAmount) {
        return this.minimumAmount <= benefitAmount;
    }
}

