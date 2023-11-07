package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.atLeastOnce;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Spy
    Burger testBurger;
    @Mock
    Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient sauce;
    @Mock
    private Ingredient filling;
    private Burger burger;

    @Test
    public void setBunsPositive() {
        Burger testBurger = new Burger();
        testBurger.setBuns(bun);
        assertEquals(bun, testBurger.bun);
    }

    @Test
    public void addIngredientPositive() {
        testBurger.addIngredient(ingredient);
        assertEquals(List.of(ingredient), testBurger.ingredients);
    }

    @Test
    public void removeIngredientPositive() {
        testBurger.addIngredient(sauce);
        testBurger.addIngredient(filling);
        testBurger.removeIngredient(1);
        Mockito.verify(testBurger, atLeastOnce()).removeIngredient(1);
        assertTrue(testBurger.ingredients.contains(sauce));
        assertFalse(testBurger.ingredients.contains(filling));
    }

    @Test
    public void moveIngredientsPositiveTest() {
        testBurger.addIngredient(sauce);
        testBurger.addIngredient(filling);
        testBurger.moveIngredient(Constants.FIRST_INDEX, Constants.SECOND_INDEX);
        Mockito.verify(testBurger).moveIngredient(Constants.FIRST_INDEX, Constants.SECOND_INDEX);
        assertEquals("Ингредиенты поменялись местами", sauce, testBurger.ingredients.get(Constants.SECOND_INDEX));
    }

    @Test
    public void getPriceTest() {
        testBurger.setBuns(bun);
        testBurger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(Constants.BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(Constants.INGREDIENT_PRICE);
        var actualPrice = testBurger.getPrice();
        var expectedPrice = Constants.BUN_PRICE * 2 + Constants.INGREDIENT_PRICE;
        assertEquals(expectedPrice, actualPrice, 0.5);
    }

    @Test
    public void getReceiptTest() {
        testBurger.setBuns(bun);
        testBurger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(Constants.BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(Constants.BUN_PRICE);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn(Constants.FILLING_NAME);
        Mockito.when(ingredient.getPrice()).thenReturn(Constants.INGREDIENT_PRICE);
        String actualReceipt = testBurger.getReceipt();
        assertEquals(Constants.RECEIPT, actualReceipt);
    }
}