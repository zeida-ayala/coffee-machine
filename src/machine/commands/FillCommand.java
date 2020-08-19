package machine.commands;

import machine.CoffeeMachine;
import machine.enums.StatusMachine;
import machine.handlers.MenuHandler;

public class FillCommand  implements ICommand {
    private CoffeeMachine machine;

    public FillCommand(CoffeeMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute(MenuHandler menu) {
        machine.setStatus(StatusMachine.FILLING);
        menu.generateMenuForFill(machine.getIngredientsDispenser());
        machine.fill(menu.getIngredientsSupplied(), menu.getCups());
        machine.setStatus(StatusMachine.BACKING);
    }
}
