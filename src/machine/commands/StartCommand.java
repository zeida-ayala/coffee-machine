package machine.commands;

import machine.CoffeeMachine;
import machine.enums.StatusMachine;
import machine.handlers.MenuHandler;

public class StartCommand implements ICommand {
    private CoffeeMachine machine;

    public StartCommand(CoffeeMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute(MenuHandler menuHandler) {
        machine.setStatus(StatusMachine.STARTING);
        machine.init();
        menuHandler.displayMenu();
        machine.setStatus(StatusMachine.WAITING);
    }
}
