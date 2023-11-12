package christmas.domain;

import static christmas.utils.ErrorMessages.INVALID_DATE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.DayOfWeek;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("VisitDate 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class VisitDateTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 32})
    void 범위에_벗어난_날짜가_입력되면_예외를_던진다(int inputDate) {
        Assertions.assertThatThrownBy(() -> new VisitDate(inputDate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_DATE);
    }

    @ParameterizedTest
    @MethodSource("provideDateAndDayOfWeek")
    void 날짜에_대한_요일을_계산한다(int date, DayOfWeek expect) {
        DayOfWeek dayOfWeek = new VisitDate(date).getDayOfWeek();

        assertEquals(dayOfWeek, expect);
    }

    private static Stream<Arguments> provideDateAndDayOfWeek() {
        return Stream.of(
                Arguments.of(1, DayOfWeek.FRIDAY),
                Arguments.of(9, DayOfWeek.SATURDAY),
                Arguments.of(25, DayOfWeek.MONDAY),
                Arguments.of(31, DayOfWeek.SUNDAY)
        );
    }
}
