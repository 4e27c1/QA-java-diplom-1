package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngridientTets {
    private IngredientType type;
    private  String name;
    private float price;

    @Test
    public void getName(){
        Ingredient testIngredient = new Ingredient(type, name, price);
        var actual = testIngredient.getName();
        Assert.assertEquals(actual, name);
    }
    @Test
    public void getPrice(){
        Ingredient testIngredient = new Ingredient(type, name, price);
        float actual = testIngredient.getPrice();
        Assert.assertTrue(actual == price);
    }

    @Test
    public void getType() {
        Ingredient testIngredient = new Ingredient(type, name, price);
        IngredientType actual = testIngredient.getType();
        Assert.assertEquals(actual, type);
    }
}

