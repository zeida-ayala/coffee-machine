package machine.commands;

import machine.handlers.MenuHandler;

public interface ICommand {
    void execute(MenuHandler menuHandler);
}
