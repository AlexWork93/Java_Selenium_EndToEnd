import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {
    WebDriver driver = new ChromeDriver();

    @Test
    public void entToEndTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().setSize(new Dimension((int) (1920 * 0.8), (int) (1080 * 0.8)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        String first_name = "EToEFirst";
        String last_name = "EToELast";
        String pass = "EToEPass1!";
        String email = "EndToEndFirst@mailinator.com";
        String phone = "1234567890";

        String itemName = "ZARA COAT 3";
        String countryForShipping = "Ukraine";

        String confirmedOrderBannerMessage = "THANKYOU FOR THE ORDER.";

        driver.get("https://www.rahulshettyacademy.com/client/");

        By emailInputFieldLocator = By.id("userEmail");
        By passwordInputFieldLocator = By.id("userPassword");
        By loginButtonLocator = By.id("login");

        By itemCardLocator = By.cssSelector("#products .row .card");
        By itemTitleLocator = By.cssSelector(".card-body h5 b");
        By itemAddToCartButtonLocator = By.cssSelector(".card-body button:last-of-type");
        By spinnerLocator = By.cssSelector("ngx-spinner div div div.ng-star-inserted");
        By successfulNotificationLocator = By.cssSelector("[role='alertdialog']");
        By cartButtonLocator = By.cssSelector("[routerlink='/dashboard/cart']");

        By cartItemLocator = By.cssSelector("div.cart ul");
        By cartItemTitleLocator = By.cssSelector("div.infoWrap h3");
        By cartCheckoutButtonLocator = By.cssSelector("div.subtotal button");

        By checkoutCountryInputLocator = By.cssSelector("[placeholder='Select Country']");
        By checkoutCountryDropdownItemLocator = By.cssSelector("section.ta-results button");
        By placeOrderButtonLocator = By.cssSelector("div.actions .action__submit");

        By confirmedOrderBannerLocator = By.cssSelector("h1.hero-primary");



        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonLocator));
        driver.findElement(emailInputFieldLocator).sendKeys(email);
        driver.findElement(passwordInputFieldLocator).sendKeys(pass);
        driver.findElement(loginButtonLocator).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loginButtonLocator));

        wait.until(ExpectedConditions.visibilityOfElementLocated(itemCardLocator));
        List<WebElement> itemCards = driver.findElements(itemCardLocator);
        WebElement itemToBuy = itemCards.stream().filter(el -> el.findElement(itemTitleLocator).getText().equalsIgnoreCase(itemName)).findFirst().orElse(null);
        if (itemToBuy != null) {
            itemToBuy.findElement(itemAddToCartButtonLocator).click();
        } else {
            Assert.fail();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(successfulNotificationLocator));
        driver.findElement(cartButtonLocator).click();

        List<WebElement> itemsInCart = driver.findElements(cartItemLocator);
        boolean isElementInCart = itemsInCart.stream().anyMatch(el -> el.findElement(cartItemTitleLocator).getText().equalsIgnoreCase(itemName));
        Assert.assertTrue(isElementInCart);
        driver.findElement(cartCheckoutButtonLocator).click();

        driver.findElement(checkoutCountryInputLocator).sendKeys(countryForShipping);
        List<WebElement> countries = driver.findElements(checkoutCountryDropdownItemLocator);
        WebElement country = countries.stream().filter(el -> el.getText().equalsIgnoreCase(countryForShipping)).findFirst().orElse(null);
        country.click();
        driver.findElement(placeOrderButtonLocator).click();

        Assert.assertEquals(driver.findElement(confirmedOrderBannerLocator).getText(), confirmedOrderBannerMessage);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
