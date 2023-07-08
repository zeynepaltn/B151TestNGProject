package techproed.tests.day24_Priority_DependsOnMethods_SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C06_SoftAssert {
    /*
    SoftAssert kullaniminda Junit'deki gibi daha once kullandigimiz methodlarin aynisini kullaniriz.
    Daha onceden kullandigimiz assertion nerde hata alirsa orda testlerin calismasini durdurur.
    SoftAssert'te ne kadar assertion kullansakta nerde assertAll() methodu kullanirsak testlerimiz de
    kullandigimiz assertionlar orda sonlanir ve hata varsa bunu bize konsolda belirtir.

     */
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); //Webdriver driver; objesini class seviyesinde olusturduk
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Url'in amazon.com.tr olup olmadığını doğrulayınız
        SoftAssert softAssert=new SoftAssert();//SoftAssert kullanabilmek icin SoftAssert classindan obje olusturmaliyiz
        softAssert.assertEquals(driver.getCurrentUrl(),"https://amazon.com.tr");//bilerek hata aliyoruz .tr yazarak
        //Başlığın best içerdiğini test edelim
        softAssert.assertTrue(driver.getTitle().contains("best"));
        //Arama kutusunda iphone aratalım
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);
        //Sonucun samsung içerip içermediğini test edin
        WebElement sonucYazisi=driver.findElement(By.xpath("//*[@class='sg-col-inner']"));
        softAssert.assertTrue(sonucYazisi.getText().contains("samsung"));//bilerek hata alicaz
        softAssert.assertAll();
        System.out.println("Burasi calismaz");//assertall dedikten sonra eger oncesinde hata varsa assertall dan sonraki kodlar calismaz

    }

    @Test
    public void test02() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Url'in amazon.com.tr olup olmadığını doğrulayınız
        SoftAssert softAssert=new SoftAssert();//SoftAssert kullanabilmek icin SoftAssert classindan obje olusturmaliyiz
        softAssert.assertEquals(driver.getCurrentUrl(),"https://amazon.com.tr");//bilerek hata aliyoruz .tr yazarak
        //Başlığın best içerdiğini test edelim
        softAssert.assertTrue(driver.getTitle().contains("best"));
        //Arama kutusunda iphone aratalım
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);
        //Sonucun samsung içerip içermediğini test edin
        WebElement sonucYazisi=driver.findElement(By.xpath("//*[@class='sg-col-inner']"));
        softAssert.assertTrue(sonucYazisi.getText().contains("samsung"));//bilerek hata alicaz

        System.out.println("Burasi calisir");//cunku assertall'dan once kullandik
        softAssert.assertAll();

    }

    @Test
    public void test03() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Url'in amazon.com.tr olup olmadığını doğrulayınız
        SoftAssert softAssert=new SoftAssert();//SoftAssert kullanabilmek icin SoftAssert classindan obje olusturmaliyiz
        softAssert.assertNotEquals(driver.getCurrentUrl(),"https://amazon.com.tr");
        //Başlığın best içerdiğini test edelim
        softAssert.assertFalse(driver.getTitle().contains("best"));
        softAssert.assertAll();
        //Arama kutusunda iphone aratalım
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);
        //Sonucun samsung içerip içermediğini test edin
        WebElement sonucYazisi=driver.findElement(By.xpath("//*[@class='sg-col-inner']"));
        softAssert.assertFalse(sonucYazisi.getText().contains("samsung"));

        System.out.println("Burasi calisir");


    }
}
