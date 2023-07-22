package techproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {

    @DataProvider
    public static Object[][] sehirverileri() {
        return new Object[][]{{"Ankara","Ic Anadolu","06"},
                {"Izmir", "Ege", "35"},
                {"Diyarbakir", "Dogu", "21"}};
    }
}
