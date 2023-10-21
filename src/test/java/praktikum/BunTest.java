package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    @Test
    public void getName(){
        Bun testBun = new Bun(Constants.BUN_NAME, Constants.BUN_PRICE);
        var actual = testBun.getName();
        Assert.assertEquals(actual, Constants.BUN_NAME);
    }

    @Test
    public void getPrice(){
        Bun testBun = new Bun(Constants.BUN_NAME, Constants.BUN_PRICE);
        float actual = testBun.getPrice();
        Assert.assertEquals(Constants.BUN_PRICE, actual, 0.0);
    }
}