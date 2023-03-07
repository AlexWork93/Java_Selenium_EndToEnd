package Pages;

import AbstractHelpers.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage extends BasePage {
    WebDriver driver;
    public CartPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    private final By cartItemLocator = By.cssSelector("div.cart ul");
    private final By cartItemTitleLocator = By.cssSelector("div.infoWrap h3");
    private final By cartCheckoutButtonLocator = By.cssSelector("div.subtotal button");

    @Override
    public void waitUntilPageIsReady() {
        super.waitUntilPageIsReady(cartItemLocator);
    }
}
