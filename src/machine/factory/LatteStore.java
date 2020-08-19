package machine.factory;

import machine.enums.CoffeeType;

public class LatteStore extends CoffeeStore{

    @Override
    protected AbstractCoffee createCoffee() {
        return new LatteCoffee(CoffeeType.LATTE, new LatteIngredientFactory());
    }
}
