package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void setBunsPositive(){
        Burger testBurger = new Burger();
        testBurger.setBuns(bun);
        Assert.assertEquals(bun, testBurger.bun);
    }

    @Test
    public void addIngredientPositive(){
        Burger testBurger = new Burger();
        testBurger.addIngredient(ingredient);
        Mockito.verify(testBurger).addIngredient(ingredient);
        Assert.assertEquals(ingredient, testBurger.ingredients);
    }

    @Test
    public void removeIngredientPositive(){
        Burger testBurger = new Burger();
        testBurger.addIngredient(ingredient);
        testBurger.removeIngredient(1);
        Mockito.verify(testBurger).removeIngredient(1);
    }

}