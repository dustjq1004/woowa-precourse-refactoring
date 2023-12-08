package christmas;

import christmas.controller.OrderController;
import christmas.domain.Order;
import christmas.domain.PreOrder;
import christmas.dto.ReservationConfirm;
import christmas.utils.OrderGenerator;
import christmas.utils.StringConverter;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Optional;
import java.util.function.Supplier;

public class ChristmasEventProgram {

    private final InputView inputView;
    private final OutputView outputView;
    private final OrderController orderController;

    public ChristmasEventProgram(InputView inputView, OutputView outputView, OrderController orderController) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.orderController = orderController;
    }

    public void run() {
        outputView.printNotification();
        int clientReservationDate = callInputView(this::getClientReservationDate);
        Order clientOrder = callInputView(this::getClientOrder);
        PreOrder preOrder = new PreOrder(clientReservationDate, clientOrder);
        ReservationConfirm reservationConfirm = orderController.reserveOrder(preOrder);
        printResultReservation(reservationConfirm);
    }

    private <T> T callInputView(Supplier<Optional<T>> methodInput) {
        Optional<T> result;
        do {
            result = methodInput.get();
        } while (result.isEmpty());
        return result.get();
    }

    private Optional<Order> getClientOrder() {
        try {
            return Optional.of(OrderGenerator.generateOrder(inputView.readOrder()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    private Optional<Integer> getClientReservationDate() {
        try {
            return Optional.of(StringConverter.convertToInteger(inputView.readDate()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    private void printResultReservation(ReservationConfirm reservationConfirm) {
        outputView.printReservationConfirm(reservationConfirm);
    }
}
