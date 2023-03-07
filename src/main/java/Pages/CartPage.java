package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.cart ul")
    List<WebElement> cartItemLocator;
    @FindBy(css = "div.infoWrap h3")
    WebElement cartItemTitleLocator;
    @FindBy(css = "div.subtotal button")
    WebElement cartCheckoutButtonLocator;
}
