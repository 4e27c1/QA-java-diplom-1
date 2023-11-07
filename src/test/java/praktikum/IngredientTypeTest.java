package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String ingredientType;

    public IngredientTypeTest(String ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] VariableTypes() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"}
        };
    }

    @Test
    public void setIngredientType() {
        Assert.assertThat(IngredientType.valueOf(this.ingredientType), is(notNullValue()));
    }
}
