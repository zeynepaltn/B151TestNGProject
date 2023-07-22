package techproed.tests.day28_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C01_DataProviderTest {

    /*
    Dataprovider, bir çok veriyi test caselerde loop kullanmadan aktarmak için kullanılır.
    TestNg'den gelen bir özelliktir. 2 boyutlu Object Array return eder.
    Kullanımı için @Test notasyonundan sonra parametre olarak (dataprovider="method ismi") yazılır.
    Kaç tane veri ile çalışacaksak test methoduna o kadar parametre eklenir.
    Data driven testing de datalarimizi 3 farkli sekilde kullanabiliriz.
        1-.properties dosyasindan datalari alabiliriz
        2-Excel dosyasindan datalari alabiliriz-->ExcelReader class'i ile
        3-DataProvider kullanarak datalari alabiliriz-->DataProvider methodu ile
    */
        /*
    dataProvider'i database veya excel gibi dusunebiliriz.
    Istersek 10 tane test methodu olusturup burdan istedigimiz veriyi cekip kullanabiliriz
     */
    @DataProvider(name="test02")//bu dataProvider'i test02 icin kullan anlamina gelir, artik test01 hata verir ona bagli degil cunku
    public static Object[][] isimler() {
        return new Object[][]{
                {"esen"},
                {"mehmet"},
                {"esma"},
                {"ali"},
                {"mert"},
                {"burcu"},
                {"yunus"}};
    }

    @DataProvider
    public static Object[][] arabalar() {
        return new Object[][]{{"ford"},{"mercedes"},{"volvo"},{"audi"}};
    }

    /*
    Olusturdugumuz dataprovider methodunu baska bir test methodunda da kullanabiliriz
    Bunun icin @DataProvider notasyonundan sonra yeni olusturdugumuz methodun ismini (name="test02")
    olarak belirtmemiz gerekir.
     */
    @Test(dataProvider ="isimler")
    public void test01(String data) {
        System.out.println(data);
    }

    @Test(dataProvider = "test02")
    public void test02(String isim) {
        System.out.println(isim);
    }

    @Test (dataProvider = "arabalar")
    public void test03(String arabalar) {
        System.out.println(arabalar);
    }
}
