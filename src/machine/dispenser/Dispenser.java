package machine.dispenser;

import machine.enums.IngredientType;
import machine.factory.AbstractCoffee;
import machine.factory.LatteIngredientFactory;

import java.util.List;
import java.util.Map;

public class Dispenser {
    private CalculatorIngredient calculatorIngredient;
    private List<Ingredient> ingredients;
    private int numberCupsAvailable;

    public Dispenser () {
        calculatorIngredient = new CalculatorIngredient();
        calculatorIngredient.setIngredientsForCup(new LatteIngredientFactory().getIngredients());
    }

    public int getNumberCupsAvailable() {
        return numberCupsAvailable;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public Map<IngredientType, Integer> getNumberCupsByIngredient() {
        return calculatorIngredient.getNumberCupsByIngredient();
    }

    public void setNumberCupsAvailable(int numberCupsAvailable) {
        this.numberCupsAvailable = numberCupsAvailable;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void supplyIngredients (Map<IngredientType, Integer> ingredientsSupplied) {
        for (Ingredient ingredient : ingredients) {
            int totalQuantity = ingredient.getQuantity() + ingredientsSupplied.get(ingredient.getName());
            ingredient.setQuantity(totalQuantity);
        }
    }

    public void reduceQuantityIngredients(Map<IngredientType, Ingredient> ingredientsToReduce) {
        for (Ingredient ingredient : ingredients) {
            if(ingredientsToReduce.containsKey(ingredient.getName())) {
                int quantityReduced = ingredient.getQuantity() - ingredientsToReduce.get(ingredient.getName()).getQuantity();
                ingredient.setQuantity(quantityReduced);
            }
        }
    }

    public boolean hasSuppliesForCoffee(AbstractCoffee coffee, int numberCups) {
        calculatorIngredient.setIngredientsForCup(coffee.getIngredients());
        calculatorIngredient.setIngredientsCalculated(ingredients);
        calculatorIngredient.calculateNumberCups();
        return calculatorIngredient.getNumberCups() >= numberCups;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (Ingredient ingredient : ingredients) {
            builder.append(ingredient).append("\n");
        }
        builder.append(numberCupsAvailable).append(" of disposable cups");
        return builder.toString();
    }
}
