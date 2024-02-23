package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private Driver() {

    }

    /**Diger Classlardan ulaşmak için
     *
     */
    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver==null){
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver=new EdgeDriver();
                    break;
                case "firefox":
                    driver=new FirefoxDriver();
                    break;
                default:
                    driver=new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }
    /**
     Yeni Deger Ataması İçin Gerekli
     */
    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
        }
        driver=null;
    }

    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
