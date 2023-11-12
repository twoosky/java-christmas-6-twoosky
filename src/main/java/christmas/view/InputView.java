package christmas.view;

import static christmas.utils.ErrorMessages.INVALID_DATE;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.IntegerConverter;

public class InputView {
    public static final String INPUT_VISIT_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    public int readDate() {
        System.out.println(INPUT_VISIT_DATE_MESSAGE);
        String date = Console.readLine();
        return IntegerConverter.convert(date, INVALID_DATE);
    }
}
