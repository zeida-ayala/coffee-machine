package machine;

import machine.commands.*;
import machine.enums.StatusMachine;
import machine.handlers.MenuHandler;

import java.util.HashMap;
import java.util.Map;

public class ControlMachine {
    private MenuHandler menuHandler;
    private CoffeeMachine machine;
    private Map<StatusMachine, ICommand> commands;

    public ControlMachine(CoffeeMachine machine) {
        this.machine = machine;
        menuHandler = new MenuHandler();
    }

    private void initializeCommands() {
        ICommand startCommand = new StartCommand(machine);
        ICommand buyCommand = new BuyCommand(machine);
        ICommand fillCommand = new FillCommand(machine);
        ICommand takingCommand = new TakeCommand(machine);
        ICommand remainingCommand = new RemainingCommand(machine);
        ICommand backCommand = new BackCommand(machine);
        ICommand exitCommand = new ExitCommand(machine);

        commands = new HashMap<>();

        commands.put(StatusMachine.STARTING, startCommand);
        commands.put(StatusMachine.BUYING, buyCommand);
        commands.put(StatusMachine.FILLING, fillCommand);
        commands.put(StatusMachine.TAKING, takingCommand);
        commands.put(StatusMachine.REMAINING, remainingCommand);
        commands.put(StatusMachine.BACKING, backCommand);
        commands.put(StatusMachine.EXITING, exitCommand);
    }
    private void processCommand() {
        while (machine.getStatusMachine() != StatusMachine.EXITING) {
            String option = menuHandler.readStringOptionEntered();
            switch (option) {
                case "buy":
                    pressBuy();
                    break;
                case "fill":
                    pressFill();
                    break;
                case "take":
                    pressTake();
                    break;
                case "remaining":
                    pressRemaining();
                    break;
                case "back":
                    pressBack();
                    break;
                case "exit":
                    pressExit();
                    break;
                default:
                    menuHandler.printLine("Invalid action");
            }
            if (machine.getStatusMachine() != StatusMachine.EXITING) {
                displayMainMenu();
            }
        }
    }
    public void pressStart() {
        initializeCommands();
        commands.get(StatusMachine.STARTING).execute(menuHandler);
        processCommand();
    }
    private void pressBuy() {
        commands.get(StatusMachine.BUYING).execute(menuHandler);
    }
    private void pressFill() {
        commands.get(StatusMachine.FILLING).execute(menuHandler);
    }
    private void pressTake() {
        commands.get(StatusMachine.TAKING).execute(menuHandler);
    }

    private void pressRemaining() {
        commands.get(StatusMachine.REMAINING).execute(menuHandler);
    }
    private void pressBack() {
        commands.get(StatusMachine.BACKING).execute(menuHandler);
    }
    private void pressExit() {
        commands.get(StatusMachine.EXITING).execute(menuHandler);
    }


    private void displayMainMenu() {
        menuHandler.displayMenu();
    }
}
