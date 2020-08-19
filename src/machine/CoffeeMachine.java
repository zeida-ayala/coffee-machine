package machine;

import machine.dispenser.Dispenser;
import machine.dispenser.Ingredient;
import machine.enums.CoffeeType;
import machine.enums.IngredientType;
import machine.enums.Measure;
import machine.enums.StatusMachine;
import machine.factory.*;
import machine.handlers.CashHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CoffeeMachine {

    private CashHandler cashHandler;
    private Dispenser dispenser;
    private StatusMachine statusMachine;

    public CoffeeMachine () {
        cashHandler = new CashHandler();
        dispenser = new Dispenser();
        statusMachine = StatusMachine.STARTING;
    }

    public void init() {
        initializeData();
    }

    public void setStatus(StatusMachine status) {
        this.statusMachine = status;
    }

    public StatusMachine getStatusMachine() {
        return statusMachine;
    }

    public List<Ingredient> getIngredientsDispenser() {
        return dispenser.getIngredients();
    }
    public int getTotalCash() {
        return cashHandler.getTotalCash();
    }

    private void initializeData() {
        Ingredient water = new Ingredient(IngredientType.WATER,400, Measure.MILILITROS);
        Ingredient milk = new Ingredient(IngredientType.MILK,540, Measure.MILILITROS);
        Ingredient coffeeBeans = new Ingredient(IngredientType.COFFEEBEANS,120, Measure.GRAMOS);
        List<Ingredient> ingredients = new ArrayList<>(List.of(water, milk, coffeeBeans));
        dispenser.setIngredients(ingredients);
        dispenser.setNumberCupsAvailable(9);
        cashHandler.addCash(550);
    }

    public void take() {
       cashHandler.reduceCash(cashHandler.getTotalCash());
    }

    public String getDispenserDetails() {
        return dispenser.toString();
    }

    public boolean buy(String coffeeOptionSelected) {
        boolean res = false;
        AbstractCoffee coffee = null;
        CoffeeType coffeeType = CoffeeType.stream()
                .filter(c -> (String.valueOf(c.geOption()).equals(coffeeOptionSelected)))
                .findFirst()
                .get();
        if (coffeeType == CoffeeType.EXPRESSO) {
            coffee = new ExpressoStore().orderCoffee();
        } else if (coffeeType == CoffeeType.LATTE) {
            coffee = new LatteStore().orderCoffee();
        }
        else if (coffeeType == CoffeeType.CAPPUCCINO) {
            coffee = new CappuccinoStore().orderCoffee();
        }
        if (dispenser.hasSuppliesForCoffee(coffee, 1)) {
            dispenser.reduceQuantityIngredients(coffee.getMapIngredients());
            dispenser.setNumberCupsAvailable(dispenser.getNumberCupsAvailable() - 1);
            cashHandler.addCash(coffee.getPrice());
            res = true;
        }
        return res;
    }

    public void fill(Map<IngredientType, Integer> ingredientsSupplied, int cupsSupplied) {
        dispenser.supplyIngredients(ingredientsSupplied);
        dispenser.setNumberCupsAvailable(dispenser.getNumberCupsAvailable() + cupsSupplied);
    }

    public List<String> getNotEnoughIngredients() {
        List<String> ingredientsNotEnough = new ArrayList<>();
        for (IngredientType ingredient : dispenser.getNumberCupsByIngredient().keySet()) {
            if (dispenser.getNumberCupsByIngredient().get(ingredient) <= 0) {
                ingredientsNotEnough.add(ingredient.getName());
            }
        }
        return ingredientsNotEnough;
    }
}
