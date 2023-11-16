package christmas.domain;

import static christmas.exception.ErrorMessages.NOT_EXISTS_BADGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Badge Enum")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BadgeTest {

    @ParameterizedTest
    @CsvSource(value = {"1000:없음", "5000:별", "10000:트리", "20000:산타"}, delimiter = ':')
    void 혜택금액에_따라_배지이름을_반환한다(int 혜택금액, String 예상_배지_이름) {
        String 배지_이름 = Badge.getNameByBenefit(혜택금액);

        Assertions.assertEquals(배지_이름, 예상_배지_이름);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -1000, -10000})
    void 혜택금액에_대한_배지가_없는_경우_예외를_던진다(int 혜택금액) {
        assertThatThrownBy(() -> Badge.getNameByBenefit(혜택금액))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(NOT_EXISTS_BADGE);
    }
}
