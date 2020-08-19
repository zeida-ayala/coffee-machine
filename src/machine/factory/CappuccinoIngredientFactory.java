package machine.factory;

import machine.dispenser.Ingredient;
import machine.enums.IngredientType;
import machine.enums.Measure;

import java.util.ArrayList;
import java.util.List;

class CappuccinoIngredientFactory implements IIngredientFactory {
    public static int waterQuantity = 200;
    public static int milkQuantity = 100;
    public static int coffeeBeansQuantity = 12;

    @Override
    public List<Ingredient> getIngredients() {
        Ingredient water = new Ingredient(IngredientType.WATER, waterQuantity, Measure.MILILITROS);
        Ingredient coffee = new Ingredient(IngredientType.COFFEEBEANS, coffeeBeansQuantity, Measure.GRAMOS);
        Ingredient milk = new Ingredient(IngredientType.MILK, milkQuantity, Measure.MILILITROS);
        return new ArrayList<>(List.of(water, coffee, milk));
    }
}
