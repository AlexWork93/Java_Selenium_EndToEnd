import AbstractHelpers.NotificationMessages;
import Components.BaseTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testData.DataReader;

import java.io.IOException;
import java.util.Map;

public class StandAloneTest extends BaseTest {

    @Test(dataProvider = "getData1")
    public void entToEndTest(Map<String,String> input) throws Exception {

//        String first_name = "EToEFirst";
//        String last_name = "EToELast";
//        String pass = "EToEPass1!";
//        String email = "EndToEndFirst@mailinator.com";
//        String phone = "1234567890";
//
//        String itemName = "ZARA COAT 3";
//        String countryForShipping = "Ukraine";


        landingPage.openPage();
        landingPage.waitUntilPageIsReady();
        landingPage.fillLoginFormWithCredentials(input.get("email"), input.get("password"));
        landingPage.confirmLoginForm();
        landingPage.verifySuccessfulLoginNotificationIsDisplayed(NotificationMessages.Login_Successfully);
        landingPage.verifySuccessfulLogin(true);
        cataloguePage.waitUntilPageIsReady();
        cataloguePage.addItemsToCart(input.get("product"));
        cataloguePage.verifyNotificationWithTextIsDisplayed(NotificationMessages.Product_Added_To_Cart);
        cataloguePage.openCart();
        cartPage.waitUntilPageIsReady();
        cartPage.verifyIfItemIsDisplayedInCart(input.get("product"));
        cartPage.clickOnCheckoutButton();
        checkoutPage.waitUntilPageIsReady();
        checkoutPage.fillShippingFormWithFollowingData(input.get("country"));
        checkoutPage.clickOnPlaceOrderButton();
        checkoutPage.verifyConfirmedOrderTextIsDisplayed(NotificationMessages.THANKYOU_FOR_THE_ORDER);
    }

    @DataProvider
    public Object [][] getData1() throws IOException {
        DataReader dataReader = new DataReader();
        return dataReader.getJsonDataToObject("/src/test/java/testData/EndToEndData.json");
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
