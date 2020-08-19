package machine.factory;

import machine.enums.CoffeeType;

class LatteCoffee extends AbstractCoffee {
    private IIngredientFactory ingredientFactory;

    LatteCoffee(CoffeeType name, IIngredientFactory ingredientFactory) {
        super(name);
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        this.ingredients = ingredientFactory.getIngredients();
    }
}
