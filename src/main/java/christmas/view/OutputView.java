package christmas.view;

import christmas.domain.Menu;
import christmas.dto.GiftsDto;
import christmas.dto.OrdersDto;
import java.util.Map.Entry;

public class OutputView {
    public static final String OUTPUT_RESULT = "12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    public static final String OUTPUT_ORDER_MENU_LIST = "%n<주문 메뉴>";
    public static final String OUTPUT_ORDER_MENU = "%s %d개";
    public static final String OUTPUT_TOTAL_ORDER_PRICE = "%n<할인 전 총주문 금액>";
    public static final String OUTPUT_GIFT_LIST = "%n<증정 메뉴>";
    public static final String OUTPUT_GIFT = "%s %d개";
    public static final String OUTPUT_BENEFIT_LIST = "<혜택 내역>";
    public static final String OUTPUT_BENEFIT = "%s: -%d원";
    public static final String OUTPUT_TOTAL_BENEFIT = "<총혜택 금액>";
    public static final String OUTPUT_BADGE = "<12월 이벤트 배지>";

    public void printOrders(OrdersDto dto) {
        System.out.printf(OUTPUT_ORDER_MENU_LIST);
        dto.orders().entrySet().forEach(this::printOrder);
    }

    private void printOrder(Entry<String, Integer> order) {
        System.out.printf(OUTPUT_ORDER_MENU, order.getKey(), order.getValue());
    }

    public void printPrice(int price) {
        System.out.printf(OUTPUT_TOTAL_ORDER_PRICE);
        System.out.println(price);
    }

    public void printGifts(GiftsDto dto) {
        System.out.printf(OUTPUT_GIFT_LIST);
        dto.gifts().entrySet().forEach(this::printGift);
    }

    private void printGift(Entry<String, Integer> gift) {
        System.out.printf(OUTPUT_GIFT, gift.getKey(), gift.getValue());
    }
}
