package christmas.domain;

import static christmas.domain.GiftType.CHAMPAGNE;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Gifts 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GiftsTest {

    @Test
    void 총_증정_금액을_계산한다() {
        List<Gift> 증정_리스트 = List.of(new Gift(CHAMPAGNE, 1));
        Gifts gifts = new Gifts(증정_리스트);

        int 증정금액_총합 = gifts.sumPrice();

        Assertions.assertEquals(증정금액_총합, 25000);
    }

    @Test
    void 증정_내역을_반환한다() {
        List<Gift> 증정_리스트 = List.of(new Gift(CHAMPAGNE, 1));
        Gifts gifts = new Gifts(증정_리스트);

        Map<String, Integer> 할인_내역 = gifts.getResult();

        Assertions.assertEquals(할인_내역.size(), 1);
    }
}
