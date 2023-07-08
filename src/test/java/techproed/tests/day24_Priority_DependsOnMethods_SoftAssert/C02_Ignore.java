package techproed.tests.day24_Priority_DependsOnMethods_SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Ignore {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); //Webdriver driver; objesini class seviyesinde olusturduk
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //Istedigimiz test methodunu tarayip command + mouse sol tus surukle birak ile kopyalama islemi yapar
    /*Birden fazla test methodu calistirmak istedigimizde o anlik gereksiz gordugumuz test methodunu
    atlamak (ignore) isteyebiliriz. Bunun icin @Test notasyonu ustune ya da yanina @ignore notasyonu
    eklememiz yeterlidir. @Ignore notasyonu ile atladığımız method konsolda gözükmez raporlamalarda gözükür.
    Eger bir methodu tamamen iptal etmek isterseniz @Test notasyonundan sonra parametre olarak (enabled=false)
    kullanabilirsiniz.
     */
    @Ignore
    @Test(priority = 1)
    public void amazonTest() {
        driver.get("https://amazon.com");//--->ikinci olarak amazon calissin
    }
    @Test(enabled = false) //bunu yazinca yanindaki run isareti ortadan kalkti
    public void youtubeTest() {
        driver.get("https://youtube.com"); //--->youtube once calissin
    }
    @Test (priority = 2)
    public void facebookTest() {
        driver.get("https://facebook.com");//--->son olarak facebook calissin
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
