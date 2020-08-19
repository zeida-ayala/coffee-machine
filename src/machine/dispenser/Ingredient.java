package machine.dispenser;

import machine.enums.IngredientType;
import machine.enums.Measure;

public class Ingredient {
    private IngredientType name;
    private int quantity;
    private Measure measure;

    public Ingredient(IngredientType name, int quantity, Measure measure) {
        this.name = name;
        this.quantity = quantity;
        this.measure = measure;
    }

    public int getQuantity() {
        return quantity;
    }

    public IngredientType getName() {
        return name;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return quantity + " " + measure.getAbreviation() + " of " + name.getName();
    }
}