package machine.factory;

import machine.enums.CoffeeType;

class CappuccinoCoffee extends AbstractCoffee {
    private IIngredientFactory ingredientFactory;

    CappuccinoCoffee(CoffeeType name, IIngredientFactory ingredientFactory) {
        super(name);
        this.ingredientFactory = ingredientFactory;
    }
    @Override
    public void prepare() {
        this.ingredients = ingredientFactory.getIngredients();
    }
}
