package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C03_BlueRentalExcelTest {
  /*
  Test yaptigimiz sayfadaki data'lari .properties ya da excel dosyasindan alabiliriz.
  .properties dosyasindan verileri okuyabilmemiz icin ConfigReader class'i olusturmustuk, ayni sekilde
  excel dosyasindaki verileri okuyabilmek icin ExcelReader class'i olusturduk. Burdan alacagimiz
  email ve password bilgilerini String bir degiskene assign edip login testi yapacagimiz sitede
  sendKeys() methodu ile cok rahat kullanabiliriz.
   */
    ExcelReader reader=new ExcelReader("src/test/java/techproed/resources/mysmoketestdata.xlsx", "customer_info");
    String email=reader.getCellData(1,0);
    String password=reader.getCellData(1,1);
    @Test
    public void test01() {
        //BlueRentalCar sayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        //mysmoketestdata excel dosyasindan bir kullanici ile login yapalim
        BlueRentalPage blueRentalPage=new BlueRentalPage();
        blueRentalPage.login.click();
        ReusableMethods.bekle(2);
        blueRentalPage.email.sendKeys(email, Keys.TAB, password,Keys.ENTER);
        //login oldugumuzu dogrulayalim
        Assert.assertTrue(blueRentalPage.loginVerify.getText().contains("Sam"));
        /*
    Login webelementi login olduktan sonrada aynı locate sahip olabilme ihtimaline karşı
    daha garanti bir doğrulama yapmak için login olduktan sonra login webelementinin olduğu
    yerde login olduğumuz kullanıci ismi çıkacaktır. Bu webelementin yazısını getText() methodu
    ile alıp kullanıcı ismini içeriyomu içermiyomu olarak test ederiz
        */
        //sayfayi kapatalim

    }
}
