package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CataloguePage {
    WebDriver driver;

    public CataloguePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#products .row .card")
    List<WebElement> itemCardLocator;
    @FindBy(css = ".card-body h5 b")
    WebElement itemTitleLocator;
    @FindBy(css = ".card-body button:last-of-type")
    WebElement itemAddToCartButtonLocator;
    @FindBy(css = "ngx-spinner div div div.ng-star-inserted")
    WebElement spinnerLocator;
    @FindBy(css = "[role='alertdialog']")
    WebElement successfulNotificationLocator;
    @FindBy(css = "[routerlink='/dashboard/cart']")
    WebElement cartButtonLocator;
}