package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    String name = "Кунжутная";
    Float price = 7.99F;
    @Test
    public void getName(){
        Bun testBun = new Bun(name, price);
        var actual = testBun.getName();
        Assert.assertEquals(actual, name);
    }

    @Test
    public void getPrice(){
        Bun testBun = new Bun(name, price);
        float actual = testBun.getPrice();
        Assert.assertTrue(actual == price);
    }
}