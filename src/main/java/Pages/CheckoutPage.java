package Pages;

import AbstractHelpers.BasePage;
import AbstractHelpers.NotificationMessages;
import AbstractHelpers.WaitsPack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class CheckoutPage extends BasePage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private final By checkoutCountryInputLocator = By.cssSelector("[placeholder='Select Country']");
    private final By checkoutCountryDropdownItemLocator = By.cssSelector("section.ta-results button");
    private final By placeOrderButtonLocator = By.cssSelector("div.actions .action__submit");
    private final By confirmedOrderBannerLocator = By.cssSelector("h1.hero-primary");

    @Override
    public void waitUntilPageIsReady() {
        super.waitUntilPageIsReady(placeOrderButtonLocator);
    }

    public void fillShippingFormWithFollowingData(String countryName) throws Exception {
        driver.findElement(checkoutCountryInputLocator).sendKeys(countryName);
        List<WebElement> countries = driver.findElements(checkoutCountryDropdownItemLocator);
        WebElement country = countries.stream().filter(el -> el.getText().equalsIgnoreCase(countryName)).findFirst().orElse(null);
        if (country == null){
            throw new Exception("Country with name [" + countryName + "] is not found");
        }
        country.click();
    }

    public void clickOnPlaceOrderButton(){
        driver.findElement(placeOrderButtonLocator).click();
    }

    public void verifyConfirmedOrderTextIsDisplayed(NotificationMessages notificationText) throws Exception {
        waitUntilElementInCondition(ExpectedConditions.visibilityOfElementLocated(confirmedOrderBannerLocator), WaitsPack.FIVE_SECOND);
        WebElement notification = driver.findElement(confirmedOrderBannerLocator);
        String actualNotificationText = notification.getText();
        if (!actualNotificationText.equalsIgnoreCase(notificationText.getMessage())){
            throw new Exception("Expected notification text:\n" + notificationText.getMessage() + "\nActual notification text:\n" + actualNotificationText);
        }
    }
}