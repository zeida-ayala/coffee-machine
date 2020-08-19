package machine.commands;

import machine.CoffeeMachine;
import machine.enums.StatusMachine;
import machine.handlers.MenuHandler;

public class BackCommand implements ICommand {
    private CoffeeMachine machine;
    public BackCommand(CoffeeMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute(MenuHandler menu) {
        machine.setStatus(StatusMachine.BACKING);
        menu.displayMenu();
        machine.setStatus(StatusMachine.WAITING);
    }
}
