package christmas.domain;

import static christmas.domain.GiftType.CHAMPAGNE;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Gift 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GiftTest {

    @ParameterizedTest
    @CsvSource(value = {"1:25000", "2:50000", "3:75000"}, delimiter = ':')
    void 증정_개수에_따라_증정_가격을_계산한다(int 증정_개수, int 예상_증정_가격) {
        Gift gift = new Gift(CHAMPAGNE, 증정_개수);

        int 증정_가격 = gift.calculatePrice();

        Assertions.assertEquals(증정_가격, 예상_증정_가격);
    }
}
