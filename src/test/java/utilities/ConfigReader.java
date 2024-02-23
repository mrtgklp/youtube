package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {
    static Properties properties;

    static {
        String dosyaYolu = "src/configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
            properties=new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  static String getProperty(String key){
        String value=properties.getProperty(key);
        return value;
    }
}
