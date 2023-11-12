package christmas.domain;

import static christmas.utils.ErrorMessages.INVALID_DATE;

import java.time.DayOfWeek;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

    @Test
    void 날짜에_대한_요일을_계산한다() {
        // given
        int 날짜 = 9;

        // when
        DayOfWeek 요일 = new VisitDate(날짜).getDayOfWeek();

        // then
        Assertions.assertThat(요일, DayOfWeek.SATURDAY);
    }
}
