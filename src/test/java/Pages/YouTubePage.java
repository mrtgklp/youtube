package Pages;

import utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YouTubePage {
    public YouTubePage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//input[@id='search']")
    public WebElement search;

   @FindBy(css = "[id='search-icon-legacy']")
    public WebElement buttonClick;

   @FindBy(xpath = "(//a[@id='video-title'])[1]")
    public WebElement videoClick;




}
