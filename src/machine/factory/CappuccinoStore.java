package machine.factory;

import machine.enums.CoffeeType;

public class CappuccinoStore extends CoffeeStore {

    @Override
    protected AbstractCoffee createCoffee() {
        return new CappuccinoCoffee(CoffeeType.CAPPUCCINO, new CappuccinoIngredientFactory());
    }
}
