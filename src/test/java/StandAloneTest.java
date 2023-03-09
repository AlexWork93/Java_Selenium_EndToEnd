import AbstractHelpers.NotificationMessages;
import Components.BaseTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
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
    public Object [][] getData1(){
        Map<String,String> dataSet1 = new HashMap<String,String>();
        dataSet1.put("email","EndToEndFirst@mailinator.com");
        dataSet1.put("password","EToEPass1!");
        dataSet1.put("product","ZARA COAT 3");
        dataSet1.put("country","Ukraine");
        Map<String,String> dataSet2 = new HashMap<String,String>();
        dataSet2.put("email","EndToEndFirst@mailinator.com");
        dataSet2.put("password","EToEPass1!");
        dataSet2.put("product","ADIDAS ORIGINAL");
        dataSet2.put("country","Ukraine");
        Map<String,String> dataSet3 = new HashMap<String,String>();
        dataSet3.put("email","EndToEndFirst@mailinator.com");
        dataSet3.put("password","EToEPass1!");
        dataSet3.put("product","IPHONE 13 PRO");
        dataSet3.put("country","Ukraine");
        return new Object[][] {{dataSet1}, {dataSet2}, {dataSet3}};
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
