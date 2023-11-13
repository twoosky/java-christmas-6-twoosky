package christmas.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Badge Enum")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BadgeTest {

    /**
     * GIVEN 혜택 금액을 정의한다.
     * WHEN  혜택 금액에 따라 배지를 부여한다.
     * THEN  배지를 비교한다.
     */
    @ParameterizedTest
    @CsvSource(value = {"1000:없음", "5000:별", "10000:트리", "20000:산타"}, delimiter = ':')
    void 혜택금액에_따라_배지이름을_반환한다(int 혜택금액, String 예상_배지_이름) {
        // when
        String 배지_이름 = 배지.혜택금액에_따른_배지이름_반환();

        // then
        Assertions.assertEquals(배지_이름, 예상_배지_이름);
    }
}
