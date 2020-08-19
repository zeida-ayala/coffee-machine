package machine.enums;

public enum IngredientType {
    MILK("milk"),
    WATER("water"),
    COFFEEBEANS("coffee beans");

    String name;
    IngredientType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
