package techproed.tests.day26_PagesKullanimi;

import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.pages.OpenSourcePageClass;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C02_PageKullanimi {
    @Test
    public void test01() {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("opensourceUrl"));
        //kullaniciAdi (Admin), kullaniciSifre (admin123), submitButton elementlerini locate edelim
        OpenSourcePageClass.username().sendKeys(ConfigReader.getProperty("kullaniciAdi"));
        OpenSourcePageClass.password().sendKeys(ConfigReader.getProperty("sifre"));
        ReusableMethods.bekle(2);
        OpenSourcePageClass.loginButton().click();
        //Login Testinin basarili oldugunu test et
        OpenSourcePageClass.verify().isDisplayed();
    }
}
