package machine.commands;

import machine.CoffeeMachine;
import machine.enums.StatusMachine;
import machine.handlers.MenuHandler;

public class TakeCommand implements ICommand{
    private CoffeeMachine machine;

    public TakeCommand(CoffeeMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute(MenuHandler menu) {
        machine.setStatus(StatusMachine.TAKING);
        menu.printLine("I gave you $" + machine.getTotalCash());
        machine.take();
        menu.printLine("");
        machine.setStatus(StatusMachine.WAITING);
    }
}
