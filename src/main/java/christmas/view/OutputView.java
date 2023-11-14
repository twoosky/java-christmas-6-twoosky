package christmas.view;

import christmas.dto.BenefitDto;
import christmas.dto.GiftsDto;
import christmas.dto.OrdersDto;
import java.util.Map;

public class OutputView {
    public static final String OUTPUT_RESULT = "12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    public static final String OUTPUT_ORDER_MENU_LIST = "%n<주문 메뉴>%n";
    public static final String OUTPUT_ORDER_MENU = "%s %d개%n";
    public static final String OUTPUT_TOTAL_ORDER_PRICE = "%n<할인 전 총주문 금액>%n";
    public static final String OUTPUT_TOTAL_ORDER_PRICE_FORMAT = "%,d원%n";
    public static final String OUTPUT_GIFT_LIST = "%n<증정 메뉴>%n";
    public static final String OUTPUT_GIFT_FORMAT = "%s %d개%n";
    public static final String OUTPUT_BENEFIT_LIST = "%n<혜택 내역>%n";
    public static final String OUTPUT_BENEFIT_FORMAT = "%s: -%,d원%n";
    public static final String OUTPUT_GIFT_BENEFIT = "증정 이벤트";
    public static final String OUTPUT_TOTAL_BENEFIT = "%n<총혜택 금액>%n";
    public static final String OUTPUT_TOTAL_BENEFIT_FORMAT = "-%,d원%n";
    public static final String OUTPUT_DISCOUNT_PRICE = "%n<할인 후 예상 결제 금액>%n";
    public static final String OUTPUT_DISCOUNT_PRICE_FORMAT = "%,d원%n";
    public static final String OUTPUT_BADGE = "%n<12월 이벤트 배지>%n";
    public static final String OUTPUT_NOTHING = "없음";

    public void printOrders(OrdersDto dto) {
        System.out.println(OUTPUT_RESULT);
        System.out.printf(OUTPUT_ORDER_MENU_LIST);
        dto.orders().forEach(this::printOrder);
    }

    private void printOrder(String menu, int quantity) {
        System.out.printf(OUTPUT_ORDER_MENU, menu, quantity);
    }

    public void printPrice(int price) {
        System.out.printf(OUTPUT_TOTAL_ORDER_PRICE);
        System.out.printf(OUTPUT_TOTAL_ORDER_PRICE_FORMAT, price);
    }

    public void printGifts(GiftsDto dto) {
        System.out.printf(OUTPUT_GIFT_LIST);
        print(() -> dto.gifts().forEach(this::printGift), dto.gifts());
    }

    private void printGift(String gift, Integer quantity) {
        System.out.printf(OUTPUT_GIFT_FORMAT, gift, quantity);
    }

    public void printBenefit(BenefitDto dto) {
        System.out.printf(OUTPUT_BENEFIT_LIST);
        print(() -> dto.discounts().forEach(this::printDiscount), dto.discounts());
        printGiftBenefit(dto.giftPrice());
    }

    private void printGiftBenefit(int giftPrice) {
        System.out.printf(OUTPUT_BENEFIT_FORMAT, OUTPUT_GIFT_BENEFIT, giftPrice);
    }

    private void printDiscount(String discount, Integer amount) {
        System.out.printf(OUTPUT_BENEFIT_FORMAT, discount, amount);
    }

    public void printBenefitAmount(int amount) {
        System.out.printf(OUTPUT_TOTAL_BENEFIT);
        System.out.printf(OUTPUT_TOTAL_BENEFIT_FORMAT, amount);
    }

    public void printDiscountPrice(int price) {
        System.out.printf(OUTPUT_DISCOUNT_PRICE);
        System.out.printf(OUTPUT_DISCOUNT_PRICE_FORMAT, price);
    }

    public void printBadge(String badgeName) {
        System.out.printf(OUTPUT_BADGE);
        System.out.println(badgeName);
    }

    private void print(Runnable runnable, Map<String, Integer> values) {
        if (values.isEmpty()) {
            System.out.println(OUTPUT_NOTHING);
            return;
        }
        runnable.run();
    }
}
