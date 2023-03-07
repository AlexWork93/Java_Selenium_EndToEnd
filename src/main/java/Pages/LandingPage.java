package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    WebDriver driver;
    public LandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")
    WebElement emailInputFieldLocator;
    @FindBy(id = "userPassword")
    WebElement passwordInputFieldLocator;
    @FindBy(id = "login")
    WebElement loginButtonLocator;
}
