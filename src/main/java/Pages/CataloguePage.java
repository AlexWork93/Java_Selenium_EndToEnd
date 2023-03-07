package Pages;

import AbstractHelpers.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


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
    private final By successfulNotificationLocator = By.cssSelector("[role='alertdialog']");
    private final By cartButtonLocator = By.cssSelector("[routerlink='/dashboard/cart']");

    @Override
    public void waitUntilPageIsReady() {
        super.waitUntilPageIsReady(itemCardLocator);
    }
}