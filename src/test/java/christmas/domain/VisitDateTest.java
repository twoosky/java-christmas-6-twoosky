package christmas.domain;

import static christmas.utils.ErrorMessages.INVALID_DATE;

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
    void 숫자가_아닌_날짜가_입력되면_예외를_던진다() {
        // given
        String 입력_날짜 = "a";

        // when
        InputView 입력_뷰 = new InputView();

        // then
        Assertions.assertThatThrownBy(() -> 입력_뷰.readDate(입력_날짜))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_DATE);
    }
}
