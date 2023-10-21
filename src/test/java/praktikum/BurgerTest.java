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

    @Test
    public void moveIngridientsPositiveTest(){
        Burger testBurger = new Burger();
        testBurger.addIngredient(ingredient);
        testBurger.addIngredient(ingredient);
        testBurger.moveIngredient(1,2);
        Mockito.verify(testBurger).moveIngredient(1,2);
    }

    @Test
    public void getPriceTest(){
        Burger testBurger = new Burger();
        testBurger.setBuns(bun);
        testBurger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(Constants.BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(Constants.INGRIDIENT_PRICE);
        var actualPrice= testBurger.getPrice();
        var expectedPrice = Constants.BUN_PRICE*2+Constants.INGRIDIENT_PRICE;
        Assert.assertEquals(expectedPrice, actualPrice, 0.5);
    }

}