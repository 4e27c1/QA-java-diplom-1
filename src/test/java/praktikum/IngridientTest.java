package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngridientTest {
    private IngredientType type;
    private String name;
    private float price;

    public IngridientTest() {
    }

    @Test
    public void getName() {
        Ingredient testIngredient = new Ingredient(type, name, price);
        var actual = testIngredient.getName();
        Assert.assertEquals(actual, name);
    }

    @Test
    public void getPrice() {
        Ingredient testIngredient = new Ingredient(type, name, price);
        float actual = testIngredient.getPrice();
        Assert.assertEquals(actual, price, 0.0);
    }

    @Test
    public void getType() {
        Ingredient testIngredient = new Ingredient(type, name, price);
        IngredientType actual = testIngredient.getType();
        Assert.assertEquals(actual, type);
    }
}

