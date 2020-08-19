package machine.dispenser;

import machine.enums.IngredientType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class CalculatorIngredient {
    private int numberCups;
    private List<Ingredient> ingredientsCalculated;
    private Map<IngredientType, Ingredient> ingredientsForCup;
    private Map<IngredientType, Integer> numberCupsByIngredient;

    CalculatorIngredient() {
        numberCups = 0;
        ingredientsCalculated = new ArrayList<>();
        ingredientsForCup = new HashMap<>();
        numberCupsByIngredient = new HashMap<>();
    }

    public int getNumberCups() {
        return numberCups;
    }

    public Map<IngredientType, Integer> getNumberCupsByIngredient() {
        return numberCupsByIngredient;
    }

    public void setIngredientsForCup(List<Ingredient> ingredientsForCup) {
        this.ingredientsForCup = ingredientsForCup.stream()
                .collect(Collectors.toMap(Ingredient::getName, ingredient -> ingredient));
    }

    public void setIngredientsCalculated(List<Ingredient> ingredients) {
        this.ingredientsCalculated = ingredients;
    }

    public void calculateNumberCups() {
        this.numberCups = 0;
        this.numberCupsByIngredient = new HashMap<>();
        for (Ingredient ingredient : ingredientsCalculated){
            if (ingredientsForCup.containsKey(ingredient.getName())) {
                numberCupsByIngredient.put(ingredient.getName(), (int) Math.floor(ingredient.getQuantity()/ingredientsForCup.get(ingredient.getName()).getQuantity()));
            }
        }
        this.numberCups = numberCupsByIngredient.values().stream().min(Integer::compare).get();
    }
}
