package machine.factory;

import machine.dispenser.Ingredient;
import machine.enums.CoffeeType;
import machine.enums.IngredientType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractCoffee {
    protected CoffeeType name;
    protected List<Ingredient> ingredients;
    protected int price;

    AbstractCoffee(CoffeeType name) {
        this.name = name;
        this.price = name.getPrice();
        ingredients = new ArrayList<>();
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public Map<IngredientType, Ingredient> getMapIngredients() {
        return ingredients.stream()
                .collect(Collectors.toMap(Ingredient::getName, ingredient -> ingredient));
    }

    public CoffeeType getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    abstract void prepare();
}
