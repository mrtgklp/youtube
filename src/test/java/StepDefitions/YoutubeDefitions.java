package StepDefitions;

import Pages.YouTubePage;
import utilities.ConfigReader;
import utilities.Driver;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import utilities.ReuseableMethods;


public class YoutubeDefitions {

    YouTubePage youTubePage = new YouTubePage();
    Faker faker = new Faker();


    @Given("Kullanıcı YouTube Ana Sayfasına Gider")
    public void kullanıcı_you_tube_ana_sayfasına_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("youTube_url"));
    }

    @Then("Kullanıcı Search Kısmında Arama Yapabilmeli")
    public void kullanıcı_search_kısmında_arama_yapabilmeli() {
        ReuseableMethods.bekle(4);
        youTubePage.search.sendKeys("Ramazan Tunc");
        ReuseableMethods.bekle(5);
        youTubePage.buttonClick.click();
    }

    @Then("Kullanıcı Gelen Aramalar Sonucu Video Tıklayabilmeli")
    public void kullanıcı_gelen_aramalar_sonucu_video_tıklayabilmeli() {
           youTubePage.videoClick.click();
    }

    @Then("Kullanıcı Begeni Tusuna Basabilmeli")
    public void kullanıcı_begeni_tusuna_basabilmeli() {

    }

    @Then("Kullanıcı Abone Olabilmeli")
    public void kullanıcı_abone_olabilmeli() {

    }

    @Then("Kullanıcı Youtube Kapatır")
    public void kullanıcı_youtube_kapatır() {

    }
}
