package christmas.domain;

import static christmas.domain.DiscountType.CHRISTMAS_DDAY;
import static christmas.domain.DiscountType.SPECIAL;
import static christmas.domain.DiscountType.WEEKDAY;
import static christmas.domain.DiscountType.WEEKEND;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Discounts 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DiscountsTest {

    @ParameterizedTest
    @MethodSource("정책에대한할인금액__예상할인금액_제공")
    void 할인금액의_총합을_계산한다(List<Integer> 할인금액, int 예상_할인금액_총합) {
        Discounts discounts = new Discounts(할인정책에_따른_할인객체_리스트_생성(할인금액));

        int 할인금액_총합 = discounts.sumDiscount();

        Assertions.assertEquals(할인금액_총합, 예상_할인금액_총합);
    }

    private static Stream<Arguments> 정책에대한할인금액__예상할인금액_제공() {
        return Stream.of(
                Arguments.of(List.of(3400, 1000, 4046, 0), 8446),
                Arguments.of(List.of(0, 0, 0, 6069), 6069),
                Arguments.of(List.of(1600, 0, 2023, 0), 3623)
        );
    }

    private List<Discount> 할인정책에_따른_할인객체_리스트_생성(List<Integer> amounts) {
        return List.of(
                new Discount(CHRISTMAS_DDAY, amounts.get(0)),
                new Discount(SPECIAL, amounts.get(1)),
                new Discount(WEEKDAY, amounts.get(2)),
                new Discount(WEEKEND, amounts.get(3))
        );
    }

    @ParameterizedTest
    @MethodSource("정책에대한할인금액_예상할인내역개수_제공")
    void 할인_내역을_반환한다(List<Integer> 할인금액, int 예상_할인내역_개수) {
        Discounts discounts = new Discounts(할인정책에_따른_할인객체_리스트_생성(할인금액));

        Map<DiscountType, Integer> 할인내역 = discounts.getResult();

        Assertions.assertEquals(할인내역.size(), 예상_할인내역_개수);
    }

    private static Stream<Arguments> 정책에대한할인금액_예상할인내역개수_제공() {
        return Stream.of(
                Arguments.of(List.of(3400, 1000, 4046, 0), 3),
                Arguments.of(List.of(0, 0, 0, 6069), 1),
                Arguments.of(List.of(1600, 0, 2023, 0), 2)
        );
    }
}
