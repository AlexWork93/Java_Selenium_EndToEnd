import AbstractHelpers.NotificationMessages;
import Pages.CartPage;
import Pages.CataloguePage;
import Pages.CheckoutPage;
import Pages.LandingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait;
    LandingPage landingPage;
    CataloguePage cataloguePage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @BeforeClass
    public void beforeClass(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().setSize(new Dimension((int) (1920 * 0.8), (int) (1080 * 0.8)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        landingPage = new LandingPage(driver);
        cataloguePage = new CataloguePage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }
    @Test
    public void entToEndTest() throws Exception {

        String first_name = "EToEFirst";
        String last_name = "EToELast";
        String pass = "EToEPass1!";
        String email = "EndToEndFirst@mailinator.com";
        String phone = "1234567890";

        String itemName = "ZARA COAT 3";
        String countryForShipping = "Ukraine";


        landingPage.openPage();
        landingPage.waitUntilPageIsReady();
        landingPage.fillLoginFormWithCredentials(email, pass);
        landingPage.confirmLoginForm();
        landingPage.verifySuccessfulLogin(true);
        cataloguePage.waitUntilPageIsReady();
        cataloguePage.addItemsToCart(itemName);
        cataloguePage.verifyNotificationWithTextIsDisplayed(NotificationMessages.Product_Added_To_Cart);
        cataloguePage.openCart();
        cartPage.waitUntilPageIsReady();
        cartPage.verifyIfItemIsDisplayedInCart(itemName);
        cartPage.clickOnCheckoutButton();
        checkoutPage.waitUntilPageIsReady();
        checkoutPage.fillShippingFormWithFollowingData(countryForShipping);
        checkoutPage.clickOnPlaceOrderButton();
        checkoutPage.verifyConfirmedOrderTextIsDisplayed(NotificationMessages.THANKYOU_FOR_THE_ORDER);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
