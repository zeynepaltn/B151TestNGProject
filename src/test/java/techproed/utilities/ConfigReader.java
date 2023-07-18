package techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /*
    Properties uzantili dosyaya erisebilmemiz icin Properties class'indan obje olusturmamiz gerekir
    bu olusturdugumuz obje ile akisa aldigimiz dosya yolunu load(fis) methodu ile properties dosyasindaki
    key degerini return edebiliriz
     */
    static Properties properties;
    static {
        try {
            FileInputStream fis = new FileInputStream("configuration.properties");
            properties = new Properties();
            properties.load(fis);//-->fis'in okudugu bilgileri properties'e yukler
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }
    public static String getProperty(String key){
        String value=properties.getProperty(key);//-->getProperty(key) methodu properties dosyasindaki key'in degerini verir
        return value;
    }
}
