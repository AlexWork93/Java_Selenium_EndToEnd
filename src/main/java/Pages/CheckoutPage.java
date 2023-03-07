package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[placeholder='Select Country']")
    WebElement checkoutCountryInputLocator;
    @FindBy(css = "section.ta-results button")
    List<WebElement> checkoutCountryDropdownItemLocator;
    @FindBy(css = "div.actions .action__submit")
    WebElement placeOrderButtonLocator;
}