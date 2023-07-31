package techproed.tests.day28_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C02_DataProviderTest {
    @DataProvider
    public static Object[][] arabalar() {
        return new Object[][]{{"volvo"},{"audi"},{"mercedes"},{"ford"}};
    }

    /*
        Google sayfasına gidip
        DataProvider ile belirtilen araç isimlerini aratalım
         */
    @Test(dataProvider = "arabalar")
    public void test01(String araclar) {
        //Google sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
        GooglePage googlePage = new GooglePage();
        googlePage.cerez.click();
        //Dataprovider'daki verilerle arama yapalım

        googlePage.aramaKutusu.sendKeys(araclar, Keys.ENTER);
        ReusableMethods.bekle(3);
        //Her arama için sayfa resmi alalım
        ReusableMethods.tumSayfaResmi(araclar);//paranteze araclar ekle eger hata verirse

        //Sayfayı kapatalım
        Driver.closeDriver();

    }
}