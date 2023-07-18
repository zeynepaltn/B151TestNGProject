package techproed.tests.day25_POM;

import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class C01_DriverTest {
    @Test
    public void test01() {
        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().get("https://youtube.com");
        Driver.getDriver().get("https://facebook.com");//close burada sadece facebook'u kapatir, yukaridan asagi calisiyor ve close facebook'dan sonra geldigi icin sadece facebook'u kapatir
        Driver.closeDriver();
        /*
        Bu method'da driver'i if blogu icine almadigimizdan dolayi her bir sayfayi farkli bir pencerede acti.
        Asagidaki ornek'de driver'i if blogu icine alip test edecegiz.
         */
    }

    @Test
    public void test02() {
        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().get("https://youtube.com");
        Driver.closeDriver();
        Driver.getDriver().get("https://facebook.com");

    }

    @Test
    public void test03() {
        //Driver driver=new Driver(); //Burda Driver'in altini cizdi
        //driver.getDriver().get("https://amazon.com");
        /*
        Bu ornek de Driver class'inda singleton pattern kullanarak obje olusturmanin onune
        gecmis olduk
         */
    }
}
