package machine.commands;

import machine.CoffeeMachine;
import machine.enums.StatusMachine;
import machine.handlers.MenuHandler;

public class RemainingCommand implements ICommand {
    private CoffeeMachine machine;

    public RemainingCommand(CoffeeMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute(MenuHandler menu) {
        machine.setStatus(StatusMachine.REMAINING);
        menu.printLine("The coffee machine has:");
        menu.printLine(machine.getDispenserDetails());
        menu.printLine(machine.getTotalCash() + " of money");
        menu.printLine("");
        machine.setStatus(StatusMachine.WAITING);
    }
}
