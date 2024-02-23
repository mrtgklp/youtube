package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;




public class ReuseableMethods {
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    static Faker faker = new Faker();

    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String eskiTarihiGetir() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1); // 1 ay öncesini almak için

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(cal.getTime());
    }

    public static String guncelTarihiGetir() {
        Calendar cal = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(cal.getTime());
    }

    public static String birgunileriTarihiGetir() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, +1); // 1 GUN SONRASINI ALMAKİCİN

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(cal.getTime());
    }

    //istenilen uzunlukta bir şifre üret
    public static String generatePassword(int length) {
        Faker faker = new Faker();
        String password = faker.regexify("[A-Za-z0-9]{" + length + "}");
        return password;
    }


    // SCROLL TO ELEMENT WITH JS
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);



    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }





    public static String kelimeUret(int limit) {
        String kelime = "";
        Random r = new Random();
        for (int i = 0; i < limit; i++) {
            char c = (char)(r.nextInt(26) + 'a');
            kelime += c;
        }
        return kelime;
    }
    public static String stringSayiUret(int baslangic, int bitis){

        String sayi =""+faker.instance().number().numberBetween(baslangic, bitis);

        return sayi;


    }

    public static Integer integerSayiUret(int baslangic, int bitis){

        Integer sayi =faker.instance().number().numberBetween(baslangic, bitis);

        return sayi;

    }
    public static double generateBetweenZeroAndHundredDoubleRandomNumber() {
        Random random = new Random();
        double randomNumber = random.nextDouble() * 100; // 0 ile 100 arasında rastgele bir double sayı üretme
        return randomNumber;
    }

    public static String phoneNumberUret() {

     String phoneNumber=   faker.instance().number().numberBetween(300, 899)
                + "-" + faker.instance().number().numberBetween(100, 999)
                + "-" + faker.instance().number().numberBetween(1000, 9999);
        return phoneNumber;
    }
    public static String ssnUret() {

        String ssn=  faker.instance().number().numberBetween(100, 800)
                + "-" + faker.instance().number().numberBetween(10, 99)
                + "-" + faker.instance().number().numberBetween(1000, 9999);
        return ssn;
    }


    //Click Method
    public static void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", element);
        }
    }

    public static WebElement waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void webElementResmi(WebElement element) {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/screenshot/webElementScreenshot" + tarih + ".png";

        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //ExtentReport
    public static void extentReport() {
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/reports/extentReport_" + tarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);

        //Raporda gözükmesini istediğimiz bilgiler için
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Erol");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");
    }



}
