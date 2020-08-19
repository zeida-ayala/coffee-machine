package machine.factory;

import machine.dispenser.Ingredient;

import java.util.List;

interface IIngredientFactory{
    List<Ingredient> getIngredients();
}
