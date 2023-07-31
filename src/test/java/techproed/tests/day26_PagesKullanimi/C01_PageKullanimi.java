package techproed.tests.day26_PagesKullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_PageKullanimi {
    @Test
    public void test01() {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        //Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");//bu sekilde de olur ama config prop ile yapalim
        Driver.getDriver().get(ConfigReader.getProperty("opensourceUrl"));
        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim
        //kullaniciAdi=Admin //sifre=admin123 //bu bilgileri .properties dosyasina koyduk
        /*
        Locateleri olusturdugumuz page class'indaki webelementlere ulasabilmek icin
        asagidaki ornekteki gibi classdaki constructor' dan obje olusturduk
         */
        OpenSourcePage sourcePage=new OpenSourcePage();
        sourcePage.username.sendKeys(ConfigReader.getProperty("kullaniciAdi"));
        sourcePage.password.sendKeys(ConfigReader.getProperty("sifre"));
        ReusableMethods.bekle(2);
        sourcePage.loginButton.click();
        ReusableMethods.bekle(2);

        //Login Testinin basarili oldugunu test et
        Assert.assertTrue(sourcePage.verify.isDisplayed());
    }
}
