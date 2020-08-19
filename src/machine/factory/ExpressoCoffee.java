package machine.factory;

import machine.enums.CoffeeType;

class ExpressoCoffee extends AbstractCoffee {
    private IIngredientFactory ingredientFactory;
    ExpressoCoffee(CoffeeType name, IIngredientFactory ingredientFactory) {
        super(name);
        this.ingredientFactory = ingredientFactory;
    }
    @Override
    public void prepare() {
        this.ingredients = ingredientFactory.getIngredients();
    }
}
