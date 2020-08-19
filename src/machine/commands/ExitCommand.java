package machine.commands;

import machine.CoffeeMachine;
import machine.enums.StatusMachine;
import machine.handlers.MenuHandler;

public class ExitCommand implements ICommand {
    private CoffeeMachine machine;

    public ExitCommand(CoffeeMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute(MenuHandler menu) {
        machine.setStatus(StatusMachine.EXITING);
    }
}
