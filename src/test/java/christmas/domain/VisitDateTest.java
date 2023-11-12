package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class VisitDateTest {

    @Test
    void 범위에_벗어난_날짜가_입력되면_예외를_던진다() {
        // given
        int 입력_날짜 = 32;

        // when & then
        Assertions.assertThatThrownBy(() -> 날짜_생성_요청(입력_날짜))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
}
