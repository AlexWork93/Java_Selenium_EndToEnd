import AbstractHelpers.NotificationMessages;
import Components.BaseTest;
import org.testng.annotations.Test;

public class StandAloneTest2 extends BaseTest {

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
        landingPage.verifySuccessfulLoginNotificationIsDisplayed(NotificationMessages.Login_Successfully);
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

    @Test
    public void invalidLogin() throws Exception {

        String first_name = "EToEFirst";
        String last_name = "EToELast";
        String pass = "1EToEPass1!";
        String email = "1EndToEndFirst@mailinator.com";
        String phone = "1234567890";

        String itemName = "ZARA COAT 3";
        String countryForShipping = "Ukraine";


        landingPage.openPage();
        landingPage.waitUntilPageIsReady();
        landingPage.fillLoginFormWithCredentials(email, pass);
        landingPage.confirmLoginForm();
        landingPage.verifyNotificationWithTextIsDisplayed(NotificationMessages.Incorrect_email_or_password);
        landingPage.verifySuccessfulLogin(false);

    }

}
