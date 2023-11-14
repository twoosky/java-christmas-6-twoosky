package christmas.view;

import static christmas.exception.ErrorMessages.INVALID_DATE;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.IntegerConverter;

public class InputView {
    public static final String WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    public static final String INPUT_ORDER_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    public static final String INPUT_VISIT_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    public int readDate() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(INPUT_VISIT_DATE_MESSAGE);
        String date = Console.readLine();
        return IntegerConverter.convert(date, INVALID_DATE);
    }

    public String readOrders() {
        System.out.println(INPUT_ORDER_MESSAGE);
        return Console.readLine();
    }
}
