package christmas.domain;

import static christmas.exception.ErrorMessages.INVALID_DATE;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.DayOfWeek;
import java.util.List;
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
    @MethodSource("방문날짜_예상요일_제공")
    void 날짜에_대한_요일을_계산한다(int 방문_날짜, DayOfWeek 예상_요일) {
        DayOfWeek dayOfWeek = new VisitDate(방문_날짜).getDayOfWeek();

        assertEquals(dayOfWeek, 예상_요일);
    }

    private static Stream<Arguments> 방문날짜_예상요일_제공() {
        return Stream.of(
                Arguments.of(1, FRIDAY),
                Arguments.of(9, SATURDAY),
                Arguments.of(25, MONDAY),
                Arguments.of(31, SUNDAY)
        );
    }

    @ParameterizedTest
    @MethodSource("요일리스트_방문날짜_예상포함여부_제공")
    void 방문_요일_포함여부를_반환한다(List<DayOfWeek> 요일_리스트, int 방문_날짜, boolean 예상_포함여부) {
        VisitDate visitDate = new VisitDate(방문_날짜);

        boolean 포함_여부 = visitDate.isContainDayOfDay(요일_리스트);

        assertEquals(포함_여부, 예상_포함여부);
    }

    private static Stream<Arguments> 요일리스트_방문날짜_예상포함여부_제공() {
        return Stream.of(
                Arguments.of(List.of(SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY), 1, false),
                Arguments.of(List.of(SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY), 25, true),
                Arguments.of(List.of(FRIDAY, SATURDAY), 30, true)
        );
    }
}
