package machine.commands;

import machine.CoffeeMachine;
import machine.enums.StatusMachine;
import machine.handlers.MenuHandler;

public class BuyCommand implements ICommand{
    private CoffeeMachine machine;

    public BuyCommand(CoffeeMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute(MenuHandler menu) {
        machine.setStatus(StatusMachine.BUYING);
        menu.generateMenuForBuy();
        if (menu.isValidOptionForBuy() && menu.isValidCoffeeType()) {
           if (machine.buy(menu.getOptionSelected())) {
               menu.printLine("I have enough resources, making you a coffee!");
           } else {
               machine.getNotEnoughIngredients().stream()
                       .forEach(s -> menu.printLine("Sorry, not enough " + s + "!"));
           }
        } else {
            if (menu.isBackToMainMenu()) {
                machine.setStatus(StatusMachine.BACKING);
            } else {
                menu.printLine("Invalid option");
            }
        }
        machine.setStatus(StatusMachine.BACKING);
    }
}
