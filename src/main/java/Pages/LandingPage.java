package Pages;

import AbstractHelpers.BasePage;
import AbstractHelpers.WaitsPack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LandingPage extends BasePage {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private final By emailInputFieldLocator = By.id("userEmail");
    private final By passwordInputFieldLocator = By.id("userPassword");
    private final By loginButtonLocator = By.id("login");
    String URL = "https://www.rahulshettyacademy.com/client/";

    public void openPage() {
        super.openUrl(URL);
    }

    @Override
    public void waitUntilPageIsReady() {
        super.waitUntilPageIsReady(loginButtonLocator);
    }

    public void fillLoginFormWithCredentials(String email, String password) {
        driver.findElement(emailInputFieldLocator).sendKeys(email);
        driver.findElement(passwordInputFieldLocator).sendKeys(password);
    }

    public void confirmLoginForm() {
        driver.findElement(loginButtonLocator).click();
    }

    public void verifySuccessfulLogin(boolean successful) {
        if (successful) {
            waitUntilElementInCondition(ExpectedConditions.invisibilityOfElementLocated(loginButtonLocator), WaitsPack.FIVE_SECOND);
        } else {
            //Here should be error verification
        }
    }
}
