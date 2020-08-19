package machine.factory;

import machine.enums.CoffeeType;

public class ExpressoStore extends CoffeeStore {

    @Override
    protected AbstractCoffee createCoffee() {
        return new ExpressoCoffee(CoffeeType.EXPRESSO, new ExpressoIngredientFactory());
    }
}
