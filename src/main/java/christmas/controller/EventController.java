package christmas.controller;

import static christmas.utils.RepeatReader.repeatRead;

import christmas.domain.Bill;
import christmas.domain.Orders;
import christmas.domain.Restaurant;
import christmas.domain.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
    private final Restaurant restaurant;
    private final InputView inputView;
    private final OutputView outputView;

    public EventController(Restaurant restaurant, InputView inputView, OutputView outputView) {
        this.restaurant = restaurant;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        VisitDate visitDate = repeatRead(this::readDate);
        Orders orders = repeatRead(this::readOrders);

        Bill bill = restaurant.order(visitDate, orders);

        printOrders(orders);
        printBill(bill, orders);
    }

    private VisitDate readDate() {
        int date = inputView.readDate();
        return new VisitDate(date);
    }

    private Orders readOrders() {
        String orders = inputView.readOrders();
        return new Orders(orders);
    }

    private void printOrders(Orders orders) {
        outputView.printOrders(orders.getOrders());
        outputView.printPrice(orders.getTotalPrice());
    }

    private void printBill(Bill bill, Orders orders) {
        outputView.printGifts(bill.getGiftDto());
        outputView.printBenefit(bill.getBenefitDto());
        outputView.printBenefitAmount(bill.getTotalBenefit(orders));
        outputView.printDiscountPrice(bill.getDiscountPrice(orders));
        outputView.printBadge(bill.getBadgeName());
    }
}
