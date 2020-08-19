import machine.CoffeeMachine;
import machine.ControlMachine;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        ControlMachine control = new ControlMachine(machine);
        control.pressStart();
    }
}


