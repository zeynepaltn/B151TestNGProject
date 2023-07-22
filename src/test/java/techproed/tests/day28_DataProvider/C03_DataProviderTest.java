package techproed.tests.day28_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C03_DataProviderTest {
    @DataProvider
    public static Object[][] blueRental() {
        return new Object[][]{
                {"sam.walker@bluerentalcars.com","c!fas_art"},
                {"kate.brown@bluerentalcars.com ","c!fas_art"},
                {"raj.khan@bluerentalcars.com","v7Hg_va^"},
                {"pam.raymond@bluerentalcars.com","Nga^g6!"}
        };
    }

    @Test(dataProvider = "blueRental")
    public void test01(String mail, String password) {
        //BlueRentalCAr sitesine gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        //DataProvider daki mail ve password bilgileri ile giris yapalim
        BlueRentalPage rentalPage=new BlueRentalPage();
        rentalPage.login.click();
        ReusableMethods.bekle(2);
        rentalPage.email.sendKeys(mail, Keys.TAB, password, Keys.ENTER);
        ReusableMethods.bekle(2);
        //Sayfayi kapatalim
        Driver.closeDriver();
    }
}
