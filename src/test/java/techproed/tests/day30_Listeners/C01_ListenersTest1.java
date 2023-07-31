package techproed.tests.day30_Listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(techproed.utilities.Listeners.class)
public class C01_ListenersTest1 {
    /*
    Olusturxugumuz test class'inda listeners yapisini kullanabilmek icin class'dan once @Listeners
    notasyonu olustururuz. Ve bu notasyona parametre olarak olusturmus oldugumuz listeners class'inin yolunu belirtiriz.
     */

    @Test
    public void test01() {
        System.out.println("test");
        Assert.assertTrue(true);
        Assert.assertEquals(2,2);
    }
}
