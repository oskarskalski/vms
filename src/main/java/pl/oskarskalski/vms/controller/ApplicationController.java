package pl.oskarskalski.vms.controller;

import pl.oskarskalski.vms.feature.Option;
import pl.oskarskalski.vms.feature.UserInput;


public class ApplicationController {
    private final FunctionalityController functionalityController = new FunctionalityController();
    private final Option option = new Option();

    public void controller() {
        while (true) {
            option.printOptions();

            UserInput userInput = new UserInput();
            try {
                int value = Integer.parseInt(
                        userInput.getValueFromUser("Write number: "));

                if (value == 0) {
                    break;
                }

                functionalityController.controller(value);

            } catch (NumberFormatException numberFormatException) {
                System.out.println("Something went wrong. Probably you wrote a wrong value. Try again!");
            }
        }
    }
}
