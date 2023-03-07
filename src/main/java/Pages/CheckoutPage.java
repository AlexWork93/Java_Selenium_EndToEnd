package Pages;

import AbstractHelpers.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckoutPage extends BasePage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private final By checkoutCountryInputLocator = By.cssSelector("[placeholder='Select Country']");
    private final By checkoutCountryDropdownItemLocator = By.cssSelector("section.ta-results button");
    private final By placeOrderButtonLocator = By.cssSelector("div.actions .action__submit");

    @Override
    public void waitUntilPageIsReady() {
        super.waitUntilPageIsReady(placeOrderButtonLocator);
    }
}