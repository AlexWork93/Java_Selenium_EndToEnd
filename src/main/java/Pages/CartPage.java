package Pages;

import AbstractHelpers.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


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

    public void verifyIfItemIsDisplayedInCart(String itemName) throws Exception {
        List<WebElement> itemsInCart = driver.findElements(cartItemLocator);
        boolean isElementInCart = itemsInCart.stream().anyMatch(el -> el.findElement(cartItemTitleLocator).getText().equalsIgnoreCase(itemName));
        if (!isElementInCart){
            throw new Exception("Item with name [" + itemName + "] is not found");
        }
    }

    public void clickOnCheckoutButton() {
        driver.findElement(cartCheckoutButtonLocator).click();
    }
}
