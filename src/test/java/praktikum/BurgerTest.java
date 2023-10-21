package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.atLeastOnce;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Spy
    Burger testBurger;
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
        //Burger testBurger = new Burger();
        testBurger.addIngredient(ingredient);
       // Mockito.verify(testBurger).addIngredient(ingredient);
       Assert.assertEquals(List.of(ingredient), testBurger.ingredients);
    }

    @Test
    public void removeIngredientPositive(){
       // Burger testBurger = new Burger();
        testBurger.addIngredient(ingredient);
        testBurger.addIngredient(ingredient);
        testBurger.removeIngredient(1);
        Mockito.verify(testBurger, atLeastOnce()).removeIngredient(1);
    }

    @Test
    public void moveIngridientsPositiveTest(){
       // Burger testBurger = new Burger();
        testBurger.addIngredient(ingredient);
        testBurger.addIngredient(ingredient);
        testBurger.moveIngredient(Constants.FIRST_INDEX, Constants.SECOND_INDEX);
        Mockito.verify(testBurger).moveIngredient(Constants.FIRST_INDEX, Constants.SECOND_INDEX);
    }

    @Test
    public void getPriceTest(){
       // Burger testBurger = new Burger();
        testBurger.setBuns(bun);
        testBurger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(Constants.BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(Constants.INGREDIENT_PRICE);
        var actualPrice= testBurger.getPrice();
        var expectedPrice = Constants.BUN_PRICE* 2 +Constants.INGREDIENT_PRICE;
        Assert.assertEquals(expectedPrice, actualPrice, 0.5);
    }

    @Test
    public void getReceiptTest(){
       // Burger testBurger = new Burger();
        testBurger.setBuns(bun);
        testBurger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(Constants.BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(Constants.BUN_PRICE);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn(Constants.FILLING_NAME);
        Mockito.when(ingredient.getPrice()).thenReturn(Constants.INGREDIENT_PRICE);
        String actualReceipt = testBurger.getReceipt();
        Assert.assertEquals(Constants.RECEIPT, actualReceipt);
    }

}