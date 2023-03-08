package Pages;

import AbstractHelpers.BasePage;
import AbstractHelpers.NotificationMessages;
import AbstractHelpers.WaitsPack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class CataloguePage extends BasePage {
    WebDriver driver;

    public CataloguePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private final By itemCardLocator = By.cssSelector("#products .row .card");
    private final By itemTitleLocator = By.cssSelector(".card-body h5 b");
    private final By itemAddToCartButtonLocator = By.cssSelector(".card-body button:last-of-type");
    private final By spinnerLocator = By.cssSelector("ngx-spinner div div div.ng-star-inserted");

    @Override
    public void waitUntilPageIsReady() {
        super.waitUntilPageIsReady(itemCardLocator);
    }

    public void addItemsToCart(String itemName) throws Exception {
        List<WebElement> itemCards = driver.findElements(itemCardLocator);
        WebElement itemToBuy = itemCards.stream()
                .filter(el -> el.findElement(itemTitleLocator).getText().equalsIgnoreCase(itemName))
                .findFirst().orElse(null);
        if (itemToBuy != null) {
            itemToBuy.findElement(itemAddToCartButtonLocator).click();
        } else {
            throw new Exception("Item with name [" + itemName + "] is not found");
        }
    }

}