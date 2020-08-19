package machine.factory;

import machine.dispenser.Ingredient;
import machine.enums.IngredientType;
import machine.enums.Measure;

import java.util.ArrayList;
import java.util.List;

class ExpressoIngredientFactory implements IIngredientFactory {
    public static int waterQuantity = 250;
    public static int coffeeBeansQuantity = 16;

    @Override
    public List<Ingredient> getIngredients() {
        Ingredient water = new Ingredient(IngredientType.WATER, waterQuantity, Measure.MILILITROS);
        Ingredient coffee = new Ingredient(IngredientType.COFFEEBEANS, coffeeBeansQuantity, Measure.GRAMOS);
        return new ArrayList<>(List.of(water, coffee));
    }
}
