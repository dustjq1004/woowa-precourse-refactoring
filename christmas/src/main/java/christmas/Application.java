package christmas;

import christmas.controller.OrderController;
import christmas.service.DiscountPolicyService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        ChristmasEventProgram christmasEventProgram = new ChristmasEventProgram(
                new InputView(), new OutputView(), new OrderController(new DiscountPolicyService())
        );
        christmasEventProgram.run();
    }
}
