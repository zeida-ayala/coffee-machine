package machine.handlers;

import machine.dispenser.Ingredient;
import machine.enums.CoffeeType;
import machine.enums.IngredientType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MenuHandler {
    private Scanner scanner;
    private String optionSelected;
    private Map<IngredientType, Integer> ingredientsSupplied;
    private int cups;
    public MenuHandler() {
        scanner = new Scanner(System.in);
    }

    public String getOptionSelected() {
        return optionSelected;
    }

    public Map<IngredientType, Integer> getIngredientsSupplied() {
        return ingredientsSupplied;
    }

    public int getCups() {
        return cups;
    }

    public void displayMenu(){
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }

    public void printLine(String val) {
        System.out.println(val);
    }

    public void generateMenuForBuy() {
        System.out.print("What do you want to buy? ");
        List<String> options = CoffeeType.stream()
                .map(coffeeType -> coffeeType.geOption() + " - " + coffeeType.getName()).collect(Collectors.toList());

        for (int i = 0; i < options.size(); i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(options.get(i));
        }
        System.out.print(", back - to main menu:");
        optionSelected = readStringOptionEntered();
    }

    public boolean isValidOptionForBuy() {
        boolean res = true;
        try {
            if (!isBackToMainMenu()) {
                int option = Integer.valueOf(optionSelected);
                if (option <= 0) {
                    System.out.println("Invalid Option");
                    res = false;
                }
            }
        }
        catch (NumberFormatException e) {
            res = false;
            System.out.println("Invalid Option");
        }
        return res;
    }

    public boolean isValidCoffeeType() {
        CoffeeType coffeeType = CoffeeType.stream()
                .filter(coffee -> (String.valueOf(coffee.geOption()).equals(optionSelected)))
                .findFirst()
                .orElse(null);
        return coffeeType != null;
    }

    public void generateMenuForFill(List<Ingredient> ingredients) {
        ingredientsSupplied = new HashMap<>();
        for (Ingredient ingredient : ingredients) {
            System.out.println("How many " + ingredient.getMeasure().getAbreviation() + " of " + ingredient.getName().getName() + " do you want to add:");
            Integer quantity = Integer.valueOf(readStringOptionEntered());
            ingredientsSupplied.put(ingredient.getName(), quantity);
        }
        printLine("Write how many disposable cups of coffee do you want to add:");
        cups = Integer.valueOf(readStringOptionEntered());
    }

    public String readStringOptionEntered() {
        return scanner.nextLine();
    }

    public boolean isBackToMainMenu() {
        return optionSelected.equals("back");
    }
}
