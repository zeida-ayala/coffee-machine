package machine.factory;


import machine.dispenser.Ingredient;
import machine.enums.IngredientType;
import machine.enums.Measure;

import java.util.ArrayList;
import java.util.List;

public class LatteIngredientFactory implements IIngredientFactory {
    public static int waterQuantity = 350;
    public static int milkQuantity = 75;
    public static int coffeeBeansQuantity = 20;

    @Override
    public List<Ingredient> getIngredients() {
        Ingredient water = new Ingredient(IngredientType.WATER, waterQuantity, Measure.MILILITROS);
        Ingredient coffee = new Ingredient(IngredientType.COFFEEBEANS, coffeeBeansQuantity, Measure.GRAMOS);
        Ingredient milk = new Ingredient(IngredientType.MILK, milkQuantity, Measure.MILILITROS);
        return new ArrayList<>(List.of(water, coffee, milk));
    }
}
